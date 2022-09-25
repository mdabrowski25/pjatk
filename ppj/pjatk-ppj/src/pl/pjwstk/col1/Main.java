package pl.pjwstk.col1;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        for (int j = 0; j < 10; j++) {
            if (j <= 4) {
                for (int k = 0; k < j + 1; k++) {
                    System.out.print('*');
                }
                for (int k = 0; k < 10 - (j + 1); k++) {
                    System.out.print('_');
                }
            } else if (j == 5) {
                for (int n = 0; n < 5; n++) {
                    System.out.print('_');
                }
                for (int o = 0; o <= j - 1; o++) {
                    System.out.print('*');
                }
            } else {
                for (int l = 0; l < j; l++) {
                    System.out.print('_');
                }
                for (int m = 0; m < 10 - j; m++) {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }
}

