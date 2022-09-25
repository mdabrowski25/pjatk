package pl.pjwstk.repositories;

import pl.pjwstk.exceptions.NoSpaceException;
import pl.pjwstk.models.departments.Service;
import pl.pjwstk.models.machines.Vehicle;
import pl.pjwstk.models.service.CarServiceSpot;
import pl.pjwstk.models.service.ServiceSpot;
import pl.pjwstk.services.DateTimeService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRepository {
    public static int counter = 1;
    public static List<Service> services = new ArrayList<>();

    public void addService(Service service) {
        services.add(service);
    }

    public Service get(Integer id) {
        return services.get(id - 1);
    }

    public List<Service> getAll() {
        return services;
    }


    public void addCarToRepairByServiceId(int serviceChoice, Vehicle vehicleToRepair) throws NoSpaceException {
        Service service = services.get(serviceChoice - 1);
        List<CarServiceSpot> carServiceSpots = service.getSpotService().getCarServiceSpots();
        List<Integer> freeSpots = carServiceSpots.stream()
                .filter(el -> !el.isOccupied())
                .map(ServiceSpot::getId)
                .collect(Collectors.toList());
        CarServiceSpot newCarServiceSpot = new CarServiceSpot();
        newCarServiceSpot.setOccupiedTill(DateTimeService.actualDate.plusDays(14));
        newCarServiceSpot.setVehicle(vehicleToRepair);
        newCarServiceSpot.setOccupied(true);

        if (!freeSpots.isEmpty()) {
            carServiceSpots.set(freeSpots.get(0), newCarServiceSpot);
        } else {
            throw new NoSpaceException("There is no space for your car, please come back later");
        }
    }
}
