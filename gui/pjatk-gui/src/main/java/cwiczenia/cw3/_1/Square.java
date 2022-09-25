package cwiczenia.cw3._1;

import java.util.Objects;

public class Square implements Comparable<Square> {
    private int length;
    private int number;
    static int counter = 1;

    public Square(int length) {
        this.length = length;
        this.number = counter++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getArea() {
        return length * length;

    }

    @Override
    public String toString() {
        return "(" + number + "): " + getArea();
    }

    @Override
    public int compareTo(Square o) {
//        if (this.getArea() > o.getArea()) {
//            return 1;
//        } else if (this.getArea() == o.getArea()) {
//            return 0;
//        } else {
//            return -1;
//        }
        return Integer.compare(this.getArea(), o.getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return length == square.length && number == square.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, number);
    }
}
