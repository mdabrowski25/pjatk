package pl.pjwstk.models.departments;

import pl.pjwstk.models.parking.ParkingSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parking {
    List<ParkingSpace> parkingSpaces;

    public Parking(Integer numberOfSpaces) {
        ArrayList<ParkingSpace> parkingSpaces = new ArrayList<>();
        Collections.fill(parkingSpaces, new ParkingSpace());
        this.parkingSpaces = parkingSpaces;
    }
}
