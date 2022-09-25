package pl.pjwstk.egz._2_;

public class Cukierek {
    private static int counter = 1;

    int number;
    String flavour;

    public Cukierek(String flavour) {
        this.number = counter;
        this.flavour = flavour;
        counter++;
    }

    @Override
    public String toString() {
        return "Cukierek nr " + number + " smak: " + flavour;
    }

    public void setFlavour(String newFlavour) {
        this.flavour = newFlavour;
    }

    public String getFlavour() {
        return flavour;
    }
}
