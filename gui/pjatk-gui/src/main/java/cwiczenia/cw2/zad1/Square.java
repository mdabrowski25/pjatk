package cwiczenia.cw2.zad1;

public class Square extends Shape {
    private double sideSize;

    @Override
    double getPerimeter() {
        return sideSize * 4;
    }

    @Override
    double getArea() {
        return sideSize * sideSize;
    }
}
