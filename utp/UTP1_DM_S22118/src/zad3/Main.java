/**
 * @author Dąbrowski Mateusz S22118
 */

package zad3;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Lista destynacji: port_wylotu port_przylotu cena_EUR
        List<String> dest = Arrays.asList(
                "bleble bleble 2000",
                "WAW HAV 1200",
                "xxx yyy 789",
                "WAW DPS 2000",
                "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;
        List<String> result = dest.stream()
                .filter(el -> el.matches("WAW [A-Z][A-Z][A-Z].*"))
                .map(el -> {
                    String[] s = el.split(" ");
                    int v = (int) (Integer.parseInt(s[2]) * ratePLNvsEUR);
                    return "to " + s[1] + " - price in PLN: " + v;
                })
                .collect(Collectors.toList());


        for (String r : result) System.out.println(r);
    }
}
