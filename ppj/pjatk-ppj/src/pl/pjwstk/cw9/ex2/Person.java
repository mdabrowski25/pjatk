package pl.pjwstk.cw9.ex2;

import java.util.Arrays;

public class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person(String name) {
        this(name, 1990);
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public static Person getOlder(Person person1, Person person2) {
        if (person1.birthYear < person2.birthYear) {
            return person1;
        } else if (person1.birthYear == person2.getBirthYear()) {
            throw new RuntimeException("Osoby są w jednakowym wieku");
        } else {
            return person2;
        }
    }

    public static Person getOldest(Person[] people) throws Exception {
        if (Arrays.stream(people).findFirst().isEmpty()) {
            throw new Exception("Przekazana tablica jest pusta");
        }
        int minimal = 0;
        int index = 0;
        for (int i = 0; i < people.length; i++) {
           if (people[i].birthYear < minimal) {
               index = i;
           }
        }
        return people[index];
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }


}
