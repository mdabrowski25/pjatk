package pl.pjwstk.models.parking;

public class ParkingSpace {
    public static int counter = 1;
    private Integer id;
    private boolean isOccupied = false;

    public ParkingSpace() {
        this.id = counter++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

}
