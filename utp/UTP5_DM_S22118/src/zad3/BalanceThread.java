package zad3;

public class BalanceThread extends Thread {
    private Balance balanceVar;
    private int counter;

    public BalanceThread(String name, Balance balance, int counter) {
        super(name);
        this.balanceVar = balance;
        this.counter = counter;
        start();
    }

    @Override
    public void run() {
        int res = 0;
        boolean print;

        for (int i = 0; i < counter; i++) {
            // print * co 20 itr
            if (i % 20 == 0)
                print = true;
            else
                print = false;

            res = balanceVar.balance(print);
            if (res != 0) break;
        }
        System.out.println("\n" + Thread.currentThread().getName() + " konczy z wynikiem: " + res);
    }


}
