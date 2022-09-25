package cwiczenia.cw3._3;

public class Smartphone extends Device implements Phonable, Webable, Messageable {
    public Smartphone(String producer, double price) {
        super(producer, price);
    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void phone() {

    }

    @Override
    public void surfWeb() {

    }
}
