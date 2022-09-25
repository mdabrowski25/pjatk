package pl.pjwstk.cw8.ex2;

public class Number {
    private int intArg;

    public void setValue(int value){
        showValue();
        intArg = value;
        showValue();
    }

    public void showValue(){
        System.out.println(intArg);
    }
}
