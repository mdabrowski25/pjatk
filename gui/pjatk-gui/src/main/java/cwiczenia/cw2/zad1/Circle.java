package cwiczenia.cw2.zad1;

public class Circle extends Shape {
    private int radius;

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
