package pl.pjwstk.cw9.ex2;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person("Krzysio", 1960);
        Person person2 = new Person("Andrzej", 1975);
        Person person3 = new Person("Cezary", 1987);
        Person person4 = new Person("Janusz", 1970);
        Person[] people = {person1, person2, person3, person4};
        Person[] people2 = {};

        Person.getOldest(people2);
        System.out.println(person1);
        System.out.println(person1.getBirthYear());
        System.out.println(Arrays.toString(people));
        System.out.println(Person.getOlder(person3, person2));
        System.out.println(Person.getOldest(people));

        Collections.shuffle(Arrays.asList(people));
        System.out.println(Arrays.toString(people));

        System.out.println(Arrays.toString(sort(people)));

    }

    public static Person[] sort(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length - 1; j++) {
                if (people[j].getBirthYear() > people[j + 1].getBirthYear()) {
                    Person person = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = person;
                }
            }
        }
        return people;
    }
}
