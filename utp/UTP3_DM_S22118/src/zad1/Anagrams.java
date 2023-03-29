/**
 * @author Dąbrowski Mateusz S22118
 */

package zad1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {
    String path;
    String[] words;
    List<List<String>> anagramList = new ArrayList<>();
    List<char[]> pattern = new ArrayList<>();

    public Anagrams(String path) {
        this.path = path;
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(this.path))
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.words = sb.toString().split(" ");
        char[] tempChars;
        boolean notFound;
        for (int i = 0; i < this.words.length; i++) {
            if (this.pattern.size() == 0) {
                tempChars = this.words[i].toCharArray();
                Arrays.sort(tempChars);
                this.pattern.add(tempChars);
                this.anagramList.add(new ArrayList<>());
                this.anagramList.get(0).add(this.words[i]);
                continue;
            }
            tempChars = this.words[i].toCharArray();
            Arrays.sort(tempChars);
            notFound = false;
            boolean equals;
            for (int i1 = 0; i1 < this.pattern.size(); i1++) {
                equals = Arrays.equals(this.pattern.get(i1), tempChars);
                if (equals) {
                    this.anagramList.get(i1).add(this.words[i]);
                    notFound = false;
                    break;
                } else {
                    notFound = true;
                }
            }
            if (notFound) {
                this.pattern.add(tempChars);
                this.anagramList.add(new ArrayList<>());
                this.anagramList.get(this.pattern.size() - 1).add(this.words[i]);
            }
        }
    }

    public List<List<String>> getSortedByAnQty() {
        List<List<String>> toReturn = new ArrayList<>(anagramList);
        toReturn.sort((e1, e2) -> {
            if (e1.size() > e2.size()) {
                return -1;
            } else if (e1.size() < e2.size()) {
                return 1;
            } else {
                int i = e1.get(0).compareTo(e2.get(0));
                if (i > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return toReturn;
    }

    public List<String> getAnagramsFor(String next) {
        char[] charsToCompare = next.toCharArray();
        Arrays.sort(charsToCompare);
        int indexToRet = -1;
        for (int i = 0; i < pattern.size(); i++) {
            if (Arrays.equals(pattern.get(i), charsToCompare)) {
                indexToRet = i;
            }
        }
        if (indexToRet != -1) {
            return anagramList.get(indexToRet)
                    .stream()
                    .filter(el -> !el.equals(next))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();

    }
}
