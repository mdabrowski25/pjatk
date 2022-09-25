package pl.pjwstk.app;


import pl.pjwstk.services.CheckerService;
import pl.pjwstk.services.DateTimeService;

public class Main {
    public static void main(String[] args) {
        DateTimeService dateTimeService = new DateTimeService();
        CheckerService checkerService = new CheckerService();
        Thread menuStart = new Thread(() -> {
            AppControl appControl = new AppControl();
            appControl.controlLoop();
        });

        dateTimeService.start();
        menuStart.start();
        checkerService.start();

        try {
            dateTimeService.join();
            menuStart.join();
            checkerService.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
