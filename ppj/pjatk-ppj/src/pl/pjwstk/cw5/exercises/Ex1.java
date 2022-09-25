package pl.pjwstk.cw5.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        //1
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));

        //2
        int wrt = 2;

        for (int i = 0; i < array.length; i++) {
            array[i] *= wrt;
        }

        System.out.println(Arrays.toString(array));

        //3
        boolean flag = false;
        while (flag) {
            System.out.println("while");
        }

        do {
            System.out.println("do while");
        } while (flag);


        //4
        int[] array2 = new int[10];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) Math.pow(2, i);
        }

        System.out.println(Arrays.toString(array2));

        //5
        char[] chars = new char[5];

        Arrays.fill(chars, '*');

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < chars.length; j++) {
                    System.out.print(chars[j] + " ");
                }
            } else {
                for (int k = 0; k < 4; k++) {
                    System.out.print(chars[k] + " ");
                }
            }
            System.out.println();
        }

        //6
        int size = 0;
        int howMany;
        int howMany2;

        for (int i = 0; i < 9; i++) {
            howMany2 = (2 * size) + 1;
            howMany = (9 - howMany2) / 2;
            for (int j = 0; j < howMany; j++) {
                System.out.print(" . ");
            }
            for (int j = 0; j < howMany2; j++) {
                System.out.print(" * ");
            }
            for (int j = 0; j < howMany; j++) {
                System.out.print(" . ");
            }
            System.out.println();
            if (i < 4) {
                size++;
            } else {
                size--;
            }
        }

        //7
        //ja posortowalem tablice, minimalna wartosc zawsze jest indeksem numer 0
        char[] chars2 = {'b', 'p', 'a', 'g', '$'};
        for (int i = 0; i < chars2.length; i++) {
            for (int j = 0; j < chars2.length - 1; j++) {
                if (chars2[j] > chars[j + 1]) {
                    char c = chars2[j];
                    chars2[j] = chars2[j + 1];
                    chars2[j + 1] = c;
                }
            }
        }
        System.out.println(Arrays.toString(chars2));

        //8
        byte[] byteArray = {0, 2, 1, 2, 1};
        byte[] byteArray2 = {0, 2, 1, 2, 1};
        System.out.println(Arrays.equals(byteArray, byteArray2));

        //9
        int[] intArray = {1, 5, 7, 4, 2, 6, -2, -20, -13};
        int[] minusArray = Arrays.stream(intArray)
                .filter(number -> number < 0)
                .sorted()
                .toArray();
        int[] plusArray = Arrays.stream(intArray)
                .filter(number -> number > 0)
                .sorted()
                .toArray();
    }
}
