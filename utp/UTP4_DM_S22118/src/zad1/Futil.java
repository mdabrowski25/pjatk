package zad1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        try {
            Visitor visitor = new Visitor(Paths.get("./" + resultFileName));
            Files.walkFileTree(Paths.get(dirName), visitor);
            visitor.preDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
