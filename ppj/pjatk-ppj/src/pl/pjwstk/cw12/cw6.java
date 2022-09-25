package pl.pjwstk.cw12;

import java.io.FileInputStream;
import java.io.IOException;

public class cw6 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        int readData;
        try {
            fileInputStream = new FileInputStream("text.txt");
            int[] asciiCounter = new int[255];
            while ((readData = fileInputStream.read()) != -1) {
                asciiCounter[readData] += 1;
            }
            readTable(asciiCounter);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readTable(int[] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(((char) i) + " " + table[i]);
        }
    }
}
