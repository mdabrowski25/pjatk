package pl.pjwstk.services;

import pl.pjwstk.models.departments.Parking;

import java.time.LocalDate;

import static pl.pjwstk.services.DateTimeService.actualDate;

public class CheckerService extends Thread {

    @Override
    public void run() {

    }

    public void checkPersonBuilderProperties(Integer id, String firstname, String lastname, LocalDate dateOfBirth, String address, String pesel) {
        nullCheck("id", id);
        stringCheck("firstname", firstname);
        stringCheck("lastname", lastname);
        stringCheck("address", address);
        stringCheck("pesel", pesel);
        dateBeforeCheck("birthdate", dateOfBirth);
    }

    public void checkServiceWarehouseBuilderProperties(Integer id,int height, int lengthA, int lengthB) {
        nullCheck("id", id);
        positiveIntNumberCheck("height", height);
        positiveIntNumberCheck("lengthA", lengthA);
        positiveIntNumberCheck("lengthB", lengthB);
    }

    public void checkConsumerWarehouseBuilderProperties(Integer id,int height, int lengthA, int lengthB) {
        nullCheck("id", id);
        positiveIntNumberCheck("height", height);
        positiveIntNumberCheck("lengthA", lengthA);
        positiveIntNumberCheck("lengthB", lengthB);
    }

    public void checkServiceBuilderProperties(Integer id,String name, String address, Parking parking) {
        nullCheck("id", id);
        stringCheck("name", name);
        stringCheck("address", address);
        nullCheck("parking", parking);

    }

    public void checkBaseVehicleBuilderProperties(String producer, String model,
                                                  int productionYear) {
        stringCheck("producer", producer);
        stringCheck("model", model);
        positiveIntNumberCheck("productionYear", productionYear);
    }

    private void positiveIntNumberCheck(String propertyName, int number) {
        if (number <= 0) {
            throw new IllegalStateException("Property " + propertyName + " cannot be less or equal to zero");
        }
    }

    private void nullCheck(String propertyName, Object obj) {
        if (obj == null) {
            throw new IllegalStateException("Property " + propertyName + " cannot be empty");
        }
    }

    private void stringCheck(String propertyName, String s) {
        if (s.isEmpty()) {
            throw new IllegalStateException("Property " + propertyName + " cannot be empty");
        }
    }

    private void dateBeforeCheck(String propertyName, LocalDate date) {
        if (date.isAfter(actualDate)) {
            throw new IllegalStateException("Property " + propertyName + " cannot be after today");
        }
    }
}
