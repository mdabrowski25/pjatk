package cwiczenia.cw3._1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(3);
        Square square2 = new Square(2);
        Square square3 = new Square(5);
        Square square4 = new Square(12);
        Square square5 = new Square(45);

        Square[] squares = {square1, square2, square3, square4, square5};

        for (Square square : squares) {
            System.out.println(square.toString());
        }

        Arrays.sort(squares);

        for (Square square : squares) {
            System.out.println(square.toString());
        }
    }
}
