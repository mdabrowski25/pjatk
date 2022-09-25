package pl.pjwstk.egz2.bytes;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

    }

    private static boolean check() {
        boolean flag = false;
        try (
                final BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"))
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String s = stringBuilder.toString();
            Pattern.compile("/+/d/d /d/d/d /d/d/d");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

