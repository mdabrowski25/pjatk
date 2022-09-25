package pl.pjwstk.egz._1_;

public class A {
    private int i;

    public A(int i) {
        i = i;
    }

    public void show() throws E2, E {
        System.out.println("A" + getI());
    }

    public int getI() {
        if (i < 0)
            try {
                throw new E3("GetI Exception");
            } catch (E3 e3) {
                System.out.println(e3.getCause() + " " + e3.getMessage());
            } finally {
                System.out.println("Błąd w GetI");
            }
        return i - 3;
    }

    public void setI(int i) {
        this.i = i * 2;
    }
}
