package pl.pjwstk.app;

import pl.pjwstk.alerts.TenantAlert;
import pl.pjwstk.exceptions.NoSpaceException;
import pl.pjwstk.exceptions.NoSuchOptionException;
import pl.pjwstk.exceptions.NoSuchPersonException;
import pl.pjwstk.exceptions.ProblematicTenantException;
import pl.pjwstk.models.departments.Service;
import pl.pjwstk.models.enums.OwnerOption;
import pl.pjwstk.models.enums.TenantOption;
import pl.pjwstk.models.machines.*;
import pl.pjwstk.models.people.Owner;
import pl.pjwstk.models.people.Person;
import pl.pjwstk.models.people.Tenant;
import pl.pjwstk.repositories.PersonRepository;
import pl.pjwstk.repositories.ServiceRepository;
import pl.pjwstk.repositories.WarehouseRepository;
import pl.pjwstk.services.DateTimeService;
import pl.pjwstk.services.PermissionService;
import pl.pjwstk.services.Printer;
import pl.pjwstk.services.logs.LoggingService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AppControl {
    OwnerOption ownerOption;
    TenantOption tenantOption;
    boolean isLogged = false;
    public static boolean appRunning = true;

    PersonRepository personRepository = new PersonRepository();
    ServiceRepository serviceRepository = new ServiceRepository();
    WarehouseRepository warehouseRepository = new WarehouseRepository();

    private final Scanner sc = new Scanner(System.in);

    OnAppInit onAppInit = new OnAppInit();
    Printer printer = new Printer();
    PermissionService permissionService = new PermissionService();
    LoggingService loggingService = new LoggingService();

    public void controlLoop() {
        onInit();
        while (appRunning) {
            if (permissionService.getLoggedUser() instanceof Owner) {
                controlLoopOwner();
            } else if (permissionService.getLoggedUser() instanceof Tenant) {
                controlLoopTenant();
            } else {
                login();
            }
        }
    }

    public void controlLoopOwner() {
        do {
            printOwnerOptions();
            ownerOption = getOwnerOption();
            switch (ownerOption) {
                case EXIT:
                    exit();
                    break;
                case LOGOUT:
                    logout();
                    break;
                case TENANTLIST:
                    printer.print(personRepository.getAllTenants().toString());
                    break;
                case SHOWSERVICECARSPOTS:
                    onShowServiceCarSpots();
                    break;
            }
        } while (ownerOption != OwnerOption.LOGOUT);
    }

    private void onShowServiceCarSpots() {
        List<Service> allServices = serviceRepository.getAll();
        printer.print(allServices.stream()
                .map(Service::toClientString)
                .collect(Collectors.toList())
                .toString());

        printer.print("Choose service number:");
        int serviceChoice = chooseServiceId(allServices);
        Service service = allServices.get(serviceChoice - 1);
        printer.print(service.getSpotService().getCarServiceSpots().toString());
    }

    public void controlLoopTenant() {
        do {
            printTenantOptions();
            tenantOption = getTenantOption();
            switch (tenantOption) {
                case EXIT:
                    exit();
                    break;
                case LOGOUT:
                    logout();
                    break;
                case REPAIR:
                    try {
                        onRepair();
                    } catch (Exception ex) {
                        printer.print("you cant repair your car in our services, first pay your debt");
                    }
                    break;
            }
        } while (tenantOption != TenantOption.LOGOUT);
    }

    private void onRepair() throws ProblematicTenantException {
        Person loggedUser = permissionService.getLoggedUser();
        if (loggedUser.getTenantAlert() == TenantAlert.WARNING){
            throw new ProblematicTenantException("Tenant has a debt!!!");
        }
        List<Service> allServices = serviceRepository.getAll();
        printer.print("Welcome, give us a second making a repair ticket");
        List<String> collect = allServices.stream()
                .map(Service::toClientString)
                .collect(Collectors.toList());
        collect.forEach(printer::print);
        printer.print("Choose a service by ID:");
        int serviceChoice = chooseServiceId(allServices);
        printer.print("Please provide your car type:");
        printer.print("1:Amphibian, 2:CityCar, 3:Motorcycle, 4:OffRoadCar, 5:OtherCar");
        int carClass = carClassTypeChoice();
        printer.print("Please provide car producer");
        String carProducer = sc.nextLine();
        printer.print("Please provide car model");
        String carModel = sc.nextLine();
        printer.print("Please provide production year");
        int productionYear = prodYearChoice();
        Vehicle vehicleToRepair;
        switch (carClass) {
            case 1:
                vehicleToRepair = Amphibian.builder()
                        .person(loggedUser)
                        .producer(carProducer)
                        .model(carModel)
                        .productionYear(productionYear)
                        .build();
                break;
            case 2:
                vehicleToRepair = CityCar.builder()
                        .person(loggedUser)
                        .producer(carProducer)
                        .model(carModel)
                        .productionYear(productionYear)
                        .build();
                break;
            case 3:
                vehicleToRepair = Motorcycle.builder()
                        .person(loggedUser)
                        .producer(carProducer)
                        .model(carModel)
                        .productionYear(productionYear)
                        .build();
                break;
            case 4:
                vehicleToRepair = OffRoadCar.builder()
                        .person(loggedUser)
                        .producer(carProducer)
                        .model(carModel)
                        .productionYear(productionYear)
                        .build();
                break;
            case 5:
                vehicleToRepair = OtherCar.builder()
                        .person(loggedUser)
                        .producer(carProducer)
                        .model(carModel)
                        .productionYear(productionYear)
                        .build();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + carClass);
        }

        try {
            serviceRepository.addCarToRepairByServiceId(serviceChoice, vehicleToRepair);
        } catch (NoSpaceException e) {
            printer.print(e.getMessage());
        }
        printer.print("Your car will be serviced until: " + DateTimeService.actualDate.plusDays(14) +
                " Thanks for your patience");

        String line = ">>>" + permissionService.getLoggedUser().toString() + " " +
                serviceRepository.get(serviceChoice).toString() + " " + vehicleToRepair + "<<<";
        loggingService.appendLine(line);

    }

    private int prodYearChoice() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            try {
                choice = getInt();
                if (choice > 1900 && choice <= DateTimeService.actualDate.getYear()) {
                    flag = true;
                }
            } catch (Exception ex) {
                printer.print("Choose proper year of production");
            }
        }
        return choice;
    }

    private int carClassTypeChoice() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            try {
                choice = getInt();
                if (choice > 0 && choice <= 5) {
                    flag = true;
                }
            } catch (Exception ex) {
                printer.print("Choose proper vehicle type");
            }
        }
        return choice;
    }

    private int chooseServiceId(List<Service> allServices) {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            try {
                choice = getInt();
                if (choice <= allServices.size() && choice > 0) {
                    flag = true;
                } else {
                    throw new NoSuchOptionException();
                }
            } catch (Exception ex) {
                printer.print("Choose proper service");
            }
        }
        return choice;
    }

    private void login() {
        printer.print("Choose user number");
        try {
            int userNumber = sc.nextInt();
            Person person = personRepository.checkPersonAndReturn(userNumber);
            permissionService.setLoggedUser(person);
            printer.print("Welcome " + person.getFirstname() + ". You are logged in");
            isLogged = true;
        } catch (NoSuchPersonException | InputMismatchException | IndexOutOfBoundsException ex) {
            printer.print("There is no such user. Login failed");
            isLogged = false;
        } finally {
            sc.nextLine();
        }
    }

    private void logout() {
        isLogged = false;
        permissionService.setLoggedUser(null);
    }

    private void printOwnerOptions() {
        printer.print("Choose:");
        for (OwnerOption element : OwnerOption.values()) {
            printer.print(element.toString());
        }
    }

    private void printTenantOptions() {
        printer.print("Choose:");
        for (TenantOption element : TenantOption.values()) {
            printer.print(element.toString());
        }
    }

    public void exit() {
        tenantOption = TenantOption.LOGOUT;
        ownerOption = OwnerOption.LOGOUT;
        printer.print("End of the program");
        sc.close();
        appRunning = false;
    }

    private OwnerOption getOwnerOption() {
        boolean optionOk = false;
        OwnerOption ownerOption = null;
        while (!optionOk) {
            try {
                ownerOption = OwnerOption.createFromInt(getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.print(e.getMessage());
            } catch (InputMismatchException e) {
                printer.print("Its not number. Try again.");
            }
        }
        return ownerOption;
    }

    private TenantOption getTenantOption() {
        boolean optionOk = false;
        TenantOption tenantOption = null;
        while (!optionOk) {
            try {
                tenantOption = TenantOption.createFromInt(getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.print(e.getMessage());
            } catch (InputMismatchException e) {
                printer.print("Its not number. Try again.");
            }
        }
        return tenantOption;
    }

    private int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    private void onInit() {
        onAppInit.repositoriesInit(personRepository, serviceRepository, warehouseRepository);
    }

}
