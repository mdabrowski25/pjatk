package pl.pjwstk.rc;

import java.util.Scanner;

public class rc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(i + y);
        scanner.close();
    }
}
