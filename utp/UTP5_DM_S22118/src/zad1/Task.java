package zad1;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task extends Thread implements Callable<Integer> {
    int c;
    int number;
    String data;
    PropertyChangeListener pCListener;
    ExecutorService executor = Executors.newFixedThreadPool(3);
    Future<Integer> resultFuture;

    public Task(int c, DefaultListModel<Task> model) {
        super();
        this.c = c;
        model.addElement(this);
    }

    public void setPropertyChangeListener(PropertyChangeListener pCListener) {
        this.pCListener = pCListener;
    }

    public void addData(String s) {
        if (pCListener != null) {
            if (data != null) {
                this.pCListener.propertyChange(new PropertyChangeEvent(this, "data", data, data += s));
            } else {
                this.pCListener.propertyChange(new PropertyChangeEvent(this, "data", data, data = s));
            }
        } else {
            data += s;
        }
    }

    @Override
    public Integer call() {

        for (int i = 0; i < c; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            number = i + (i + 1);
            this.addData("Calculateing = " + number + '\n');
        }
        this.addData("Task ended" + '\n');
        return number;
    }

    public void taskStart() {
        Callable<Integer> callable = this;
        resultFuture = executor.submit(callable);
    }

    public String taskStatus() {
        if (this.resultFuture.isCancelled()) {
            return "Interrupted";
        } else if (this.resultFuture.isDone()) {
            return "Finished";
        }
        return "Running";
    }

    public void taskStop() {
        this.addData("Task Interrupted" + '\n');
        this.resultFuture.cancel(true);
    }
}
