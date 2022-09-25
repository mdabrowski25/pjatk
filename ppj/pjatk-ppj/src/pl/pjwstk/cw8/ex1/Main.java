package pl.pjwstk.cw8.ex1;

public class Main {
    public static void main(String[] args) {
        byte variable = 20;
        MethodCurrier methodCurrier = new MethodCurrier();
        methodCurrier.setValue(2);
        methodCurrier.setValue(2.243525f);
        methodCurrier.setValue('g');
        methodCurrier.setValue(variable);
    }
}
