package pl.pjwstk.services.logs;

import pl.pjwstk.services.Printer;

import java.io.*;

public class LoggingService {
    Printer printer = new Printer();
    String fileName = "Logs.txt";
    File file;

    public LoggingService() {
        this.file = new File(fileName);
        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                printer.print("Nie udało się utworzyć pliku");
            }
        }
    }

    public void appendLine(String line) {
        try (
                var fileWriter = new FileWriter(fileName, true);
                var writer = new BufferedWriter(fileWriter)
        ){
           writer.write(line);
        } catch (Exception ex) {
            printer.print("Error - logs saving failed");
        }
    }

}

