package pl.pjwstk.models.machines;

import pl.pjwstk.models.enums.TyreType;
import pl.pjwstk.models.people.Person;

import java.time.LocalDate;

public abstract class Vehicle {
    public static int counter = 1;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public TyreType getTyreType() {
        return tyreType;
    }

    public void setTyreType(TyreType tyreType) {
        this.tyreType = tyreType;
    }

    public int getTyreCount() {
        return tyreCount;
    }

    public void setTyreCount(int tyreCount) {
        this.tyreCount = tyreCount;
    }

    public boolean isCustomBodyKit() {
        return customBodyKit;
    }

    public void setCustomBodyKit(boolean customBodyKit) {
        this.customBodyKit = customBodyKit;
    }

    public LocalDate getLastServiceVisit() {
        return lastServiceVisit;
    }

    public void setLastServiceVisit(LocalDate lastServiceVisit) {
        this.lastServiceVisit = lastServiceVisit;
    }
    
    public static Vehicle basicPropertiesSet(Vehicle vehicle, Integer id, Person person, String producer, String model, int horsepower,
                                             int weight, int topSpeed, String engine, int fuelTankCapacity,
                                             int productionYear, TyreType tyreType, int tyreCount, boolean customBodyKit,
                                             LocalDate lastServiceVisit) {
        vehicle.setId(Vehicle.counter++);
        vehicle.setPerson(person);
        vehicle.setProducer(producer);
        vehicle.setModel(model);
        vehicle.setHorsepower(horsepower);
        vehicle.setWeight(weight);
        vehicle.setTopSpeed(topSpeed);
        vehicle.setEngine(engine);
        vehicle.setFuelTankCapacity(fuelTankCapacity);
        vehicle.setProductionYear(productionYear);
        vehicle.setTyreType(tyreType);
        vehicle.setTyreCount(tyreCount);
        vehicle.setLastServiceVisit(lastServiceVisit);
        return vehicle;
    }
}
