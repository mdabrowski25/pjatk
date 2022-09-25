package pl.pjwstk.cw14;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String name = "";
        String surname = "";
        int yob = 0;
        boolean gen = true;
        short post = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name :");
        name = br.readLine();
        System.out.println("Enter surname :");
        surname = br.readLine();
        System.out.println("Enter yearOfBirth :");
        yob = Integer.parseInt(br.readLine());
        System.out.println("Enter gender :");
        gen = Boolean.parseBoolean(br.readLine());
        System.out.println("Enter postCode :");
        post = Short.parseShort(br.readLine());


        Person person = new Person(name, surname, yob, gen, post);

        System.out.println(person.toString());
    }
}
