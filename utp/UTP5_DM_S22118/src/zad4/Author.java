/**
 *
 *  @author Dąbrowski Mateusz S22118
 *
 */

package zad4;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Author implements Runnable {

    private String[] words;
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024,true);

    public Author(String[] words) {
        this.words = words;
    }

    @Override
    public void run() {
        for (int i = 0; i < words.length; i++) {
            try {
                if(words[i] != null) queue.put(words[i]);
                Thread.sleep(800);
            } catch (InterruptedException e) {

            }
        }

        //flag on end queuqe
        try {
            queue.put("END");
        } catch (InterruptedException e) {
            System.err.println("Putting to queue Interrupted");
        }
    }

    public String[] getWords() {
        return words;
    }

    public BlockingQueue<String> getQueque() {
        return queue;
    }
}
