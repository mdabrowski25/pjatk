package pl.pjwstk.egz._2_;

public class Fabryka {
    String typ;


    public Fabryka(String typ) {
        this.typ = typ;
    }

    public Cukierek[] produkuj(int number) {
        System.out.println("Produkcja " + number + " cukierkow o smaku: " + typ);
        Cukierek[] finalTab = new Cukierek[number];
        int counter = 0;
        for (int i = 0; i < finalTab.length; i++) {
            counter++;
            finalTab[i] = new Cukierek(typ);
            if (counter % 5 == 0) {
                System.out.println("Wyprodukowano 5 cukierkow");
            }
            if (i < 5) {
                finalTab[i].setFlavour(finalTab[i].getFlavour() + "11");
            }
        }
        return finalTab;
    }
}
