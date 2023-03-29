package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class ProgLang {
    Map<String, List<String>> programmersContent;
    List<String> programmers;
    List<String> languages;

    public ProgLang(String path) {
        this.programmersContent = new LinkedHashMap<>();
        this.programmers = new ArrayList<>();
        this.languages = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))
        ) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                String[] split = nextLine.split("\\t");
                String[] values = Arrays.copyOfRange(split, 1, split.length);
                List<String> valuesDistinct = Arrays.stream(values).distinct().collect(Collectors.toList());
                this.programmersContent.put(split[0], valuesDistinct);
                this.languages.add(split[0]);
                this.programmers.addAll(Arrays.asList(values));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.programmers = programmers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> getLangsMap() {
        return programmersContent;
    }

    public Map<String, List<String>> getProgsMap() {
        LinkedHashMap<String, List<String>> mapToReturn = new LinkedHashMap<>();
        for (String programmer : programmers) {
            ArrayList<String> langList = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : programmersContent.entrySet()) {
                if (entry.getValue().contains(programmer)) {
                    langList.add(entry.getKey());
                }
            }
            mapToReturn.put(programmer, langList);
        }
        return mapToReturn;
    }

    public Map<String, List<String>> getLangsMapSortedByNumOfProgs() {
        ArrayList<Map.Entry<String, List<String>>> toSort = new ArrayList<>(programmersContent.entrySet());
        return sortWithValuesQuantity(toSort);
    }


    public Map<String, List<String>> getProgsMapSortedByNumOfLangs() {
        ArrayList<Map.Entry<String, List<String>>> toSort = new ArrayList<>(getProgsMap().entrySet());
        return sortWithValuesQuantity(toSort);

    }



    private Map<String, List<String>> sortWithValuesQuantity(ArrayList<Map.Entry<String, List<String>>> entriesArrayToSort) {
        entriesArrayToSort.sort((e1, e2) -> {
            if (e1.getValue().size() > e2.getValue().size()) {
                return -1;
            } else if (e1.getValue().size() < e2.getValue().size()) {
                return 1;
            } else {
                return Integer.compare(e1.getKey().compareTo(e2.getKey()), 0);
            }
        });
        return entryListToMap(entriesArrayToSort);
    }

    public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan(int number) {
        ArrayList<Map.Entry<String, List<String>>> entries = new ArrayList<>(getProgsMap().entrySet());
        List<Map.Entry<String, List<String>>> filtered = entries.stream()
                .filter(e -> e.getValue().size() > number)
                .collect(Collectors.toList());
        return entryListToMap(filtered);
    }

    private Map<String, List<String>> entryListToMap(List<Map.Entry<String, List<String>>> entryList) {
        LinkedHashMap<String, List<String>> toReturn = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> stringListEntry : entryList) {
            toReturn.put(stringListEntry.getKey(), stringListEntry.getValue());
        }
        return toReturn;
    }
}
