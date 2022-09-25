package pl.pjwstk.rc;

public class Calculator {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
