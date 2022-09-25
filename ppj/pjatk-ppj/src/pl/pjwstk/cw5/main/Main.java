package pl.pjwstk.cw5.main;

public class Main {
    public static void main(String[] args) {

        int[] array = {2, 5, 6};

        char[][] test = new char[3][3];
        for (int i = 0; i < test.length; i++) {
            test[i][0] = 'x';
            test[i][1] ='x';
            test[i][2] ='x';
        }

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println();
        }
    }
}
