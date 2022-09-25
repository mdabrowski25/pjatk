package pl.pjwstk.egz2.point;

public class Point {
    protected int x, y;

    public Point() {
        System.out.println(
                this
        );
    }

    public Point(int x) {
        this(x, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return super.toString() + " Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(Point point) {
        if (this == point)
            return true;
        return x == point.x && y == point.y;
    }
}

