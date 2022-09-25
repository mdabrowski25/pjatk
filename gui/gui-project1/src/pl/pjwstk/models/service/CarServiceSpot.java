package pl.pjwstk.models.service;

import pl.pjwstk.models.machines.Vehicle;

import java.time.LocalDate;

public class CarServiceSpot extends ServiceSpot {
    private LocalDate occupiedTill;
    private Vehicle vehicle;

    public LocalDate getOccupiedTill() {
        return occupiedTill;
    }

    public void setOccupiedTill(LocalDate occupiedTill) {
        this.occupiedTill = occupiedTill;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "CarServiceSpot:" +
                " occupiedTill=" + occupiedTill +
                ", vehicle=" + vehicle + super.toString();
    }
}
