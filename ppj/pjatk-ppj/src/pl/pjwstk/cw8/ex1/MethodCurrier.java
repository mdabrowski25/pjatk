package pl.pjwstk.cw8.ex1;

public class MethodCurrier {
    public void setValue(int value){
        System.out.println("wartość: " +  value + " typ: int");
    }
    public void setValue(float value){
        System.out.println("wartość: " +  value + " typ: float");
    }
}
