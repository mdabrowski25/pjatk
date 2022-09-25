package pl.pjwstk.cw14;


public class Person {
    String name;
    String surname;
    int yearOfBirth;
    boolean gender;
    short postCode;

    public Person(String name, String surname, int yearOfBirth, boolean gender, short postCode) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender=" + gender +
                ", postCode=" + postCode +
                '}';
    }
}
