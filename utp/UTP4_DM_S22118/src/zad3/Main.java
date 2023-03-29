/**
 * @author Dąbrowski Mateusz S22118
 */

package zad3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))
        ) {
            Map<String, List<String>> map = reader
                    .lines()
                    .collect(Collectors.groupingBy(
                            str -> {
                                char[] arr = str.toCharArray();
                                Arrays.sort(arr);
                                return String.valueOf(arr);
                            },
                            LinkedHashMap::new,
                            Collectors.toList()
                    ));

            int maxSize = map.values().stream()
                    .map(List::size)
                    .max(Integer::compare)
                    .orElse(0);


            map.values().stream()
                    .filter(el -> el.size() == maxSize)
                    .forEach(el -> System.out.println(String.join(" ", el)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
