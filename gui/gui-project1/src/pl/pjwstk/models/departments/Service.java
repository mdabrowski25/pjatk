package pl.pjwstk.models.departments;

import pl.pjwstk.models.service.CarServiceSpot;
import pl.pjwstk.models.service.IndependentCarServiceSpot;
import pl.pjwstk.models.warehouses.Warehouse;
import pl.pjwstk.services.CheckerService;
import pl.pjwstk.services.SpotService;

import java.util.List;

public class Service {
    private Integer id;
    private String name;
    private String address;
    private List<Warehouse> warehouses;
    private Parking parking;
    private List<CarServiceSpot> carServiceSpots;
    private IndependentCarServiceSpot independentCarServiceSpot;
    private SpotService spotService = new SpotService();

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public List<CarServiceSpot> getCarServiceSpots() {
        return carServiceSpots;
    }

    public void setCarServiceSpots(List<CarServiceSpot> carServiceSpots) {
        this.carServiceSpots = carServiceSpots;
    }

    public IndependentCarServiceSpot getIndependentCarServiceSpot() {
        return independentCarServiceSpot;
    }

    public void setIndependentCarServiceSpot(IndependentCarServiceSpot independentCarServiceSpot) {
        this.independentCarServiceSpot = independentCarServiceSpot;
    }

    public SpotService getSpotService() {
        return spotService;
    }

    public void setSpotService(SpotService spotService) {
        this.spotService = spotService;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", warehouses=" + warehouses +
                ", parking=" + parking +
                ", carServiceSpots=" + carServiceSpots +
                ", independentCarServiceSpot=" + independentCarServiceSpot +
                ", spotService=" + spotService +
                '}';
    }

    public String toClientString() {
        return "Service " + id +
                ": " + name +
                ", address=" + address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final CheckerService checkerService = new CheckerService();

        private Integer id;
        private String name;
        private String address;
        private List<Warehouse> warehouses;
        private Parking parking;
        
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }
        
        public Builder warehouses(List<Warehouse> warehouses) {
            this.warehouses = warehouses;
            return this;
        }

        public Builder parking(Parking parking) {
            this.parking = parking;
            return this;
        }

        public Service build() {
            checkerService.checkServiceBuilderProperties(this.id, this.name, this.address, this.parking);

            Service service = new Service();
            service.setName(this.name);
            service.setAddress(this.address);
            service.setId(this.id);
            if (this.warehouses != null) {
                service.warehouses = this.warehouses;
            }
            return service;
        }
    }

}
