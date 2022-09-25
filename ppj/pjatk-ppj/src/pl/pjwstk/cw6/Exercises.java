package pl.pjwstk.cw6;

import java.util.Arrays;
import java.util.Scanner;
/*
UWAGA TO PORAŻKA W CHUJ PROSZE NIE CZYTAC ANI SIE Z TEGO NIE UCZYC

SPRAWDZ CO JEST NIZEJ JAK POTRZEBUJESZ SIE WKURWIC ZEBY PRACOWAC CIEZEJ
 */
public class Exercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cw1(scanner);
        cw2(scanner);
        scanner.close();
    }

    private static void cw2(Scanner scanner) {
        int input = scanner.nextInt();
        scanner.nextLine();
        int num = 3;
        int count = 1;

        if (input >= 1)
        {
            System.out.println("First "+input+" prime numbers are:");
            System.out.println(2);
        }

        for ( int i = 2 ; i <=input ; )
        {
            for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
            {
                if ( num%j == 0 )
                {
                    count = 0;
                    j = (int) Math.sqrt(num);
                }
            }
            if ( count != 0 )
            {
                System.out.println(num);
                i++;
            }
            count = 1;
            num++;
        }



    }

    private static void cw1(Scanner scanner) {
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        String s1 = Integer.toBinaryString(i);
        System.out.println(s1);
    }

    private static void cw3() {
       int[] array = {10,3,12,5,15,8};
       int[] fibonacci = new int[6];
        fibonacci[0] = 1;
        fibonacci[1] = 2;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        if (Arrays.equals(fibonacci, array)){
            System.out.println("Podany ciąg to ciąg fibonacciego");
        } else {
            System.out.println("Nie jest to ciag fibonacciego");
        }
    }
}



