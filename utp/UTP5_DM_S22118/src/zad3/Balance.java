package zad3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Balance {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private boolean useLock;

    public Balance(boolean useLock) {
        this.useLock = useLock;
    }

    public int balanceLocked(boolean print) {
        //use lock
        try {
            lock.lock();
            number++;
            if(print) System.out.print("*");
            number--;
            return number;
        } finally {
            lock.unlock();
        }
    }

    public synchronized int balanceSynchro(boolean print) {
        //use synchro
        number++;
        if (print) System.out.print("*");
        number--;
        return number;
    }

    public int balance(boolean print) {
        if(useLock)
            return balanceLocked(print);
        else
            return balanceSynchro(print);

    }
}
