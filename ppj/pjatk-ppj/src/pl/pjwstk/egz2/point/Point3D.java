package pl.pjwstk.egz2.point;


public class Point3D extends Point {
    protected int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public boolean equals(Point point) {
      return super.equals(point);
    }
}
