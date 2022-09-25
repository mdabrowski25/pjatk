package pl.pjwstk.egz2;

public class Person {
    String name;
    String surname;

    public Person() {
        System.out.println("constr: Person()");
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
