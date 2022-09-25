package pl.pjwstk.app;

import pl.pjwstk.exceptions.NoSuchPersonException;
import pl.pjwstk.models.departments.Parking;
import pl.pjwstk.models.departments.Service;
import pl.pjwstk.models.people.Owner;
import pl.pjwstk.models.people.Person;
import pl.pjwstk.models.people.Tenant;
import pl.pjwstk.models.warehouses.ServiceWarehouse;
import pl.pjwstk.models.warehouses.Warehouse;
import pl.pjwstk.repositories.PersonRepository;
import pl.pjwstk.repositories.ServiceRepository;
import pl.pjwstk.repositories.WarehouseRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class OnAppInit {
    public void repositoriesInit(PersonRepository personRepository, ServiceRepository serviceRepository,
                                 WarehouseRepository warehouseRepository) {
        try {
            personRepoInit(personRepository);
            warehouseRepoInit(warehouseRepository);
            serviceRepoInit(serviceRepository);
        } catch (NoSuchPersonException ex) {
            ex.printStackTrace();
        }
    }

    private void personRepoInit(PersonRepository personRepository) {
        personRepository.addOwner(Owner.builder()
                .id(PersonRepository.counter++)
                .firstname("Janusz")
                .lastname("Beczka")
                .pesel("123321213231")
                .address("00-000 Warsaw")
                .dateOfBirth(LocalDate.of(1988, 10, 20))
                .build());
        personRepository.addOwner(Owner.builder()
                .id(PersonRepository.counter++)
                .firstname("Andrzej")
                .lastname("Kiedyś")
                .pesel("123321213231")
                .address("00-000 Warsaw")
                .dateOfBirth(LocalDate.of(1977, 10, 20))
                .build());
        personRepository.addTenant(Tenant.builder()
                .id(PersonRepository.counter++)
                .firstname("Piotr")
                .lastname("Pawłoś")
                .pesel("123321213231")
                .address("00-000 Warsaw")
                .dateOfBirth(LocalDate.of(1988, 10, 20))
                .build());
        personRepository.addTenant(Tenant.builder()
                .id(PersonRepository.counter++)
                .firstname("Jan")
                .lastname("Kowalski")
                .pesel("123321213231")
                .address("00-000 Warsaw")
                .dateOfBirth(LocalDate.of(1988, 10, 20))
                .build());
    }

    private void warehouseRepoInit(WarehouseRepository warehouseRepository) throws NoSuchPersonException {
        warehouseRepository.addServiceWarehouse(ServiceWarehouse.builder()
                .id(WarehouseRepository.counter++)
                .lengthA(600)
                .lengthB(600)
                .height(4)
                .permittedPeople(createArrayWithPersonIds(1, 4))
                .build());
    }

    private void serviceRepoInit(ServiceRepository serviceRepository) throws NoSuchPersonException {
        serviceRepository.addService(Service.builder()
                .id(ServiceRepository.counter++)
                .name("Porshe Połczyńska")
                .address("Połczynska 99")
                .warehouses(createArrayWithWarehouseIds(1))
                .parking(new Parking(150))
                .build());
    }

    private ArrayList<Person> createArrayWithPersonIds(Integer... ids) throws NoSuchPersonException {
        ArrayList<Person> peopleToReturn = new ArrayList<>();
        for (Integer id : ids) {
            Person person = PersonRepository.people.stream()
                    .filter(el -> el.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            if (person == null) {
                throw new NoSuchPersonException("There is no such person in database");
            } else {
                peopleToReturn.add(person);
            }
        }
        return peopleToReturn;
    }

    private ArrayList<Warehouse> createArrayWithWarehouseIds(Integer... ids) throws NoSuchPersonException {
        ArrayList<Warehouse> warehousesToReturn = new ArrayList<>();
        for (Integer id : ids) {
            Warehouse warehouse = WarehouseRepository.warehouses.stream()
                    .filter(el -> el.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            if (warehouse == null) {
                throw new NoSuchPersonException("There is no such warehouse in database");
            } else {
                warehousesToReturn.add(warehouse);
            }
        }
        return warehousesToReturn;
    }
}
