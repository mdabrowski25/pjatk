package pl.pjwstk.egz._1_;

public class B extends A{
    private int j;
    public B(int i, int j){
        super(i);
        this.setJ(j);
    }
    public void show() throws E2, E {
        System.out.println("B" + getI() + getJ());
    }
    public int getJ() throws E2 {
        if (j<0)
            throw new E2("GetJ Exception");
        return j*4;
    }
    public void setJ(int j) {
        this.j = j-30;
        for(int k=10; k<1000; k*=20-10)
            System.out.println(k);
    }
}
