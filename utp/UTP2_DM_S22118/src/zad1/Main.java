/**
 * @author Dąbrowski Mateusz S22118
 */

package zad1;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*<--
 *  niezbędne importy
 */
public class Main {
    public static void main(String[] args) {

        Function<String, List<String>> flines = filepath -> {
            ArrayList<String> lines = new ArrayList<>();
            try (
                    FileReader fileReader = new FileReader(filepath);
                    BufferedReader reader = new BufferedReader(fileReader);
            ) {
                String nextLine;
                while ((nextLine = reader.readLine()) != null) {
                    lines.add(nextLine);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return lines;
        };

        Function<List<String>, String> join = list -> String.join("", list);

        Function<String, List<Integer>> collectInts = string -> {
            String replaceAll = string.replaceAll("[a-z]*[A-Z]*[,.\\-:_]*", "");
            return Arrays.stream(replaceAll.trim().split(" "))
                    .filter(el -> !el.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        };

        Function<List<Integer>, Integer> sum = intList -> intList.stream().reduce(0, Integer::sum);

        /*<--
         *  definicja operacji w postaci lambda-wyrażeń:
         *  - flines - zwraca listę wierszy z pliku tekstowego
         *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
         *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
         *  - sum - zwraca sumę elmentów listy liczb całkowitych
         */

        String fname = System.getProperty("user.home") + "/LamComFile.txt";
        InputConverter<String> fileConv = new InputConverter<>(fname);
        List<String> lines = fileConv.convertBy(flines);
        String text = fileConv.convertBy(flines, join);
        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

        System.out.println(lines);
        System.out.println(text);
        System.out.println(ints);
        System.out.println(sumints);

        List<String> arglist = Arrays.asList(args);
        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
        sumints = slistConv.convertBy(join, collectInts, sum);
        System.out.println(sumints);

    }
}
