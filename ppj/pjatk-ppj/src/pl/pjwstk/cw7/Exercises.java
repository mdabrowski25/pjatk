package pl.pjwstk.cw7;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        //Ex1
        int[] tab = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(checkTabBackwards(tab));
    }

    public static boolean checkTabBackwards(int[] tab) {
        boolean bol = true;
        int counter = 0;
        for (int i = tab.length - 1; i >= 0; i--) {
            if (tab[counter] != tab[i]) {
                bol = false;
            }
            counter++;
        }
        return bol;
    }


}
