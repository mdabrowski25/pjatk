package pl.pjwstk.egz._1_;

public class C extends B{
    private int k;
    public C(int j, int i, int k){
        super(i, j);
        this.setK(k);
    }
    public void show() throws E2, E {
        System.out.println("C" + getI() + getJ() + getK());
    }
    public int getK() throws E {
        if (k<0)
            throw new E("GetK Exception");
        return k;
    }
    public void setK(int k) {
        this.k = k;
    }
}
