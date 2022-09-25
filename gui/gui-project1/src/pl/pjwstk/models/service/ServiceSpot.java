package pl.pjwstk.models.service;

public abstract class ServiceSpot {
    public static int counter = 1;
    private Integer id;
    private boolean isOccupied;

    public ServiceSpot() {
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

    @Override
    public String toString() {
        return ", id=" + id +
                ", isOccupied=" + isOccupied + "| ";
    }
}
