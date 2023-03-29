/**
 *
 *  @author Dąbrowski Mateusz S22118
 *
 */

package zad3;


import java.util.ArrayList;

public class Main {
    static ArrayList<String> timesRes = new ArrayList<String>();
    public static void test(int threadsC, boolean lock) {
      Balance balance = new Balance(lock);
      String res = lock ? "Lock " : "Synchro ";
      String id = lock ? "L" : "S";
      res += threadsC;

      //creating threads
      Thread[] threads = new Thread[threadsC];
      long startTime = System.currentTimeMillis();

      //balanceing threads
      for (int i = 0; i < threadsC; i++)
        threads[i] = new BalanceThread(id + (i+1), balance, 100);

      //ending threads
      try {
        for (int i = 0; i < threadsC; i++)
          threads[i].join();
      } catch (InterruptedException e) {
        System.exit(1);
      }

      res += " Czas: " + (System.currentTimeMillis() - startTime);
      System.out.println("Wynik: " + res);
      timesRes.add(res);

      //Clearing threads
      for (int i = 0; i < threadsC; i++)
        threads[i] = null;
      System.gc();
    }

    public static void main(String[] args) {
      //Synchro Test
      for (int i = 100; i <= 1000; i += 100)
        test(i,false);

      //Locks Test
      for (int i = 100; i <= 1000; i += 100)
        test(i,true);

      for (String time : timesRes)
        System.out.println(time);
    }


}
