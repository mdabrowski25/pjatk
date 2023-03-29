/**
 * @author Dąbrowski Mateusz S22118
 */

package zad4;


public class Writer implements Runnable {
    Author author;
    String txt;

    public Writer(Author autor) {
        this.author = autor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                txt = author.getQueque().take();
                if ("END".equals(txt)) {
                    break;
                } else {
                    System.out.println("Queue txt: " + txt);
                }
            } catch (InterruptedException e) {
                System.err.println("Reading from queue Interrupted");
            }
        }
    }
}
