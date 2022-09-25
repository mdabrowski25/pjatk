package pl.pjwstk.services;

import pl.pjwstk.app.AppControl;

import java.time.LocalDate;

public class DateTimeService extends Thread {
    public static LocalDate actualDate;
    private final Printer printer = new Printer();

    public DateTimeService() {
        actualDate = LocalDate.now();
    }

    @Override
    public void run() {
        do {
            printer.print(actualDate.toString());
            actualDate = actualDate.plusDays(1);
            if (!AppControl.appRunning) {
                continue;
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (AppControl.appRunning);
    }

}
