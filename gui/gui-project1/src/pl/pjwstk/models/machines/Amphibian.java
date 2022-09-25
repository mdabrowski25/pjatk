package pl.pjwstk.models.machines;

import pl.pjwstk.models.enums.TyreType;
import pl.pjwstk.models.people.Person;
import pl.pjwstk.services.CheckerService;

import java.time.LocalDate;

public class Amphibian extends Vehicle {
    private int topSpeedOnWater;
    private boolean hasNavigationOnWater;

    public int getTopSpeedOnWater() {
        return topSpeedOnWater;
    }

    public void setTopSpeedOnWater(int topSpeedOnWater) {
        this.topSpeedOnWater = topSpeedOnWater;
    }

    public boolean isHasNavigationOnWater() {
        return hasNavigationOnWater;
    }

    public void setHasNavigationOnWater(boolean hasNavigationOnWater) {
        this.hasNavigationOnWater = hasNavigationOnWater;
    }

    @Override
    public String toString() {
        return "Amphibian{" +
                "topSpeedOnWater=" + topSpeedOnWater +
                ", hasNavigationOnWater=" + hasNavigationOnWater +
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
        private int topSpeedOnWater;
        private boolean hasNavigationOnWater;


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

        public Builder topSpeedOnWater(int topSpeedOnWater) {
            this.topSpeedOnWater = topSpeedOnWater;
            return this;
        }

        public Builder hasNavigationOnWater(boolean hasNavigationOnWater) {
            this.hasNavigationOnWater = hasNavigationOnWater;
            return this;
        }

        public Amphibian build() {
            checkerService.checkBaseVehicleBuilderProperties(this.producer, this.model, this.productionYear);

            Amphibian amphibian = (Amphibian) basicPropertiesSet(new Amphibian(), this.id, this.person, this.producer, this.model, this.horsepower,
                    this.weight, this.topSpeed, this.engine, this.fuelTankCapacity, this.productionYear,
                    this.tyreType, this.tyreCount, this.customBodyKit, this.lastServiceVisit);
            amphibian.setTopSpeedOnWater(this.topSpeedOnWater);
            amphibian.setHasNavigationOnWater(this.hasNavigationOnWater);
            return amphibian;
        }

    }
}
