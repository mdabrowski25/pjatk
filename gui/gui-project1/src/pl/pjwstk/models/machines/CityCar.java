package pl.pjwstk.models.machines;

import pl.pjwstk.models.enums.TyreType;
import pl.pjwstk.models.people.Person;
import pl.pjwstk.services.CheckerService;

import java.time.LocalDate;

public class CityCar extends Vehicle {
    private boolean isElectric;

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "CityCar{" +
                "isElectric=" + isElectric +
                "} " + super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final CheckerService checkerService = new CheckerService();

        private Integer id;
        private Person person;
        private String producer;
        private String model;
        private int horsepower;
        private int weight;
        private int topSpeed;
        private String engine;
        private int fuelTankCapacity;
        private int productionYear;
        private TyreType tyreType;
        private int tyreCount;
        private boolean customBodyKit;
        private LocalDate lastServiceVisit;
        private boolean isElectric;

        public Builder person(Person person) {
            this.person = person;
            return this;
        }

        public Builder producer(String producer) {
            this.producer = producer;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder horsepower(int horsepower) {
            this.horsepower = horsepower;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder topSpeed(int topSpeed) {
            this.topSpeed = topSpeed;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder fuelTankCapacity(int fuelTankCapacity) {
            this.fuelTankCapacity = fuelTankCapacity;
            return this;
        }

        public Builder tyreType(TyreType tyreType) {
            this.tyreType = tyreType;
            return this;
        }

        public Builder productionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder tyreCount(int tyreCount) {
            this.tyreCount = tyreCount;
            return this;
        }

        public Builder customBodyKit(boolean customBodyKit) {
            this.customBodyKit = customBodyKit;
            return this;
        }

        public Builder lastServiceVisit(LocalDate lastServiceVisit) {
            this.lastServiceVisit = lastServiceVisit;
            return this;
        }

        public Builder isElectric(boolean isElectric) {
            this.isElectric = isElectric;
            return this;
        }

        public CityCar build() {
            checkerService.checkBaseVehicleBuilderProperties(this.producer, this.model,
                    this.productionYear);

            CityCar cityCar = (CityCar) basicPropertiesSet(new CityCar(), this.id, this.person, this.producer, this.model, this.horsepower,
                    this.weight, this.topSpeed, this.engine, this.fuelTankCapacity, this.productionYear,
                    this.tyreType, this.tyreCount, this.customBodyKit, this.lastServiceVisit);
            cityCar.setElectric(this.isElectric);
            return cityCar;
        }

    }
}
