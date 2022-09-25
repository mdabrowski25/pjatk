package pl.pjwstk.cw2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //1
        //to rozwiazanie z metodą, czyli ty podajesz liczbe i sprawdzana jest ta liczba
        System.out.println(exercise1(4));
        //rozwiazanie ktore znamy:
        int randomInteger = 35;
        if ((randomInteger & 0b100001) == 33) {
            System.out.println("na bitach 0 i 5 wystepuja wartosci 1");
        } else {
            System.out.println("na bitach 0 i 5 nie wystepuja wartosci 1");
        }

        //2
        int result2 = 0b10101010 + 0b10101110;
        System.out.println(Integer.toBinaryString(result2));

        //3
        int integerExercise3 = 0;
        System.out.println(integerExercise3);
        //4
        int a123 = 123;
        int _1abc = 12;

        //5
        // chary są o tyle ciekawe ze za znakiem kryje sie wartosc liczbowa, według tabeli ASCII,
        // rownie dobrze mozesz zdefiniowac zmienną char wpisując liczbę
        // https://upload.wikimedia.org/wikipedia/commons/1/1b/ASCII-Table-wide.svg
        char charValue = 'a';
        char charvalue = 'b';
        // wyswietli sie na ekranie, odejmowanie tez się wykona
        System.out.println(charValue);
        System.out.println(charvalue);
        System.out.println(charValue - charvalue);

        //6
        //1 konfiguracja: wyjdzie false || false czyli false
        //2 konfiguracja: wyjdzie true || false czyli true
        //3 konfiguracja: wyjdzie false || true czyli true
        //4 konfiguracja: wyjdzie false || false czyli false

        //7
        int x = 2 * ((5 + 3) * 4 - 8); //kurwa pierdole to xD
        System.out.println(x);

        //8
        //jak chcesz zobaczyc wynik zmien wartosc zmiennej flag na true
        boolean flag = false;
        if (flag) {
            java.util.Scanner in = new java.util.Scanner(System.in);
            int studentId = in.nextInt();
            System.out.println("Hello s" + studentId);
        }

        //9
        int integer1 = 10;
        int integer2 = 3;
        System.out.println(10 / 3 + " i reszty " + 10 % 3);


        //10
        int result;
        boolean isRaining = true;

        if (isRaining) {
            result = 5;
        } else {
            result = 8;
        }

        //11
        boolean isSunShining = true;

        if (isRaining && !isSunShining) {
            System.out.println("plucha");
        } else if (isRaining && isSunShining) {
            System.out.println("tęcza");
        } else if (!isRaining && isSunShining) {
            System.out.println("słonecznie");
        } else {
            System.out.println("pochmurno");
        }

        //12
        boolean doubleFlag = false;
        // klasa random służy do generowania losowych wartości, ty moze wpisac po prostu: double gambleDouble = 0.70, po prostu hardcoded value
        Random random = new Random();
        double gambleDouble = random.nextDouble();

        System.out.println(gambleDouble);
        byte booleansValue = 0b11;
        if (gambleDouble < 0.5) {
            doubleFlag = true;
        }
        switch (booleansValue) {
            case 0b10:
                System.out.println("plucha");
                break;
            case 0b11:
                System.out.println("tęcza");
                break;
            case 0b01:
                System.out.println("słonecznie");
                break;
            case 0b00:
                System.out.println("pochmurno");
                break;
            default:
                System.out.println("coś się zepsuło");
                break;
        }

    }

    private static boolean exercise1(int randomInteger) {
        return (randomInteger & 0x1001) != 0;
    }


}
