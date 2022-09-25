package pl.pjwstk.cw9.ex1;

public class Corn {
    private int cornCount;
    private Popcorn[] makePopcorn;

    public Corn(int cornCount) {
        this.cornCount = cornCount;
        this.makePopcorn = new Popcorn[cornCount];
        for (int i = 0; i < cornCount; i++) {
            this.makePopcorn[i] = new Popcorn();
        }
    }

    public int getCornCount() {
        return cornCount;
    }

    public Popcorn[] getMakePopcorn() {
        return makePopcorn;
    }

    public void setCornCount(int cornCount) {
        this.cornCount = cornCount;
    }

    public void setMakePopcorn(Popcorn[] makePopcorn) {
        this.makePopcorn = makePopcorn;
    }
}
