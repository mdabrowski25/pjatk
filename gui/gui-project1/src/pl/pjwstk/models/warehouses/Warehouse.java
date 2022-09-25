package pl.pjwstk.models.warehouses;

import pl.pjwstk.models.people.Person;

import java.util.List;

public abstract class Warehouse {
    private Integer id;
    private int height;
    private int lengthA;
    private int lengthB;
    private int capacity;
    private List<Person> permittedPeople;


    public List<Person> getPermittedPeople() {
        return permittedPeople;
    }

    public void addPermittedPeople(Person person) {
        permittedPeople.add(person);
    }


    public Integer getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getLengthA() {
        return lengthA;
    }

    public int getLengthB() {
        return lengthB;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLengthA(int lengthA) {
        this.lengthA = lengthA;
    }

    public void setLengthB(int lengthB) {
        this.lengthB = lengthB;
    }

    public void setPermittedPeople(List<Person> permittedPeople) {
        this.permittedPeople = permittedPeople;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
