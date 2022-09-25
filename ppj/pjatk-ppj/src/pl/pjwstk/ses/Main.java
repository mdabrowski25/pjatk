package pl.pjwstk.ses;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        System.out.println(a);
        System.out.println(b);
        if (a > b) {
            System.out.println(a);
        } else if (a == b) {
            System.out.println("rowne");
        } else {
            System.out.println(b);
        }
    }

}
