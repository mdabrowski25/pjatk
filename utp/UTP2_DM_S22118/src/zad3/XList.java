package zad3;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XList<T> extends ArrayList<T> {
    public XList(T... args) {
        Collections.addAll(this, args);
    }

    public XList(Collection<T> collection) {
        super(collection);
    }

    public static <T> XList<T> of(Collection<T> collection) {
        return new XList<>(collection);
    }

    public static <T> XList<T> of(T... args) {
        return new XList<>(args);
    }

    public static XList<String> charsOf(String str) {
        return XList.of(str.split(""));
    }

    public static XList<String> tokensOf(String str, String sep) {
        String[] split = str.split(sep);
        return new XList<>(Arrays.asList(split));
    }

    public static XList<String> tokensOf(String str) {
        String[] split = str.split(" ");
        return new XList<>(Arrays.asList(split));
    }

    public XList<T> union(Collection<T> collection) {
        Stream<T> concat = Stream.concat(this.stream(), collection.stream());
        return new XList<>(concat.collect(Collectors.toList()));
    }

    public XList<T> union(T... args) {
        Stream<T> concat = Stream.concat(this.stream(), Arrays.stream(args));
        return new XList<T>(concat.collect(Collectors.toList()));
    }

    public XList<T> diff(Collection<T> collection) {
        return new XList<>(this.stream()
                .filter(el -> !collection.contains(el))
                .collect(Collectors.toList()));
    }

    public XList<T> unique() {
        return new XList<>(this.stream()
                .distinct()
                .collect(Collectors.toList()));
    }

    public XList<XList<T>> combine() {

        XList<XList<T>> xLists = new XList<XList<T>>();
        XList<T> tempList;
        for (int i = 0; i < size(); i++) {
            tempList = new XList<T>();

            ((List<T>) get(i)).forEach(tempList::add);
            xLists.add(tempList);
        }

        int size = xLists.size();
        int[] indexes = new int[size];
        XList<XList<T>> listToReturn = new XList<XList<T>>();
        int currentIndex = 0;
        boolean satisfied;


        while (true) {
            tempList = new XList<T>();

            for (int i = 0; i < size; i++) {
                tempList.add(xLists.get(i).get(indexes[i]));
            }

            listToReturn.add(tempList);

            satisfied = true;

            for (int i = 0; i < size; i++) {
                if (indexes[i] < xLists.get(i).size() - 1) {
                    satisfied = false;
                    break;
                }
            }

            if (satisfied) {
                break;
            }

            if (indexes[currentIndex] == xLists.get(currentIndex).size() - 1) {
                while (indexes[currentIndex] == xLists.get(currentIndex).size() - 1) {
                    indexes[currentIndex] = 0;
                    currentIndex++;
                }
                indexes[currentIndex]++;
                currentIndex = 0;

            } else {
                indexes[currentIndex]++;
            }

        }
        return listToReturn;
    }

    public <R> XList<R> collect(Function<T, R> function) {
        return new XList<>(this.stream()
                .map(function)
                .collect(Collectors.toList()));
    }

    public String join(String sep) {
        return this.stream()
                .map(Object::toString)
                .collect(Collectors.joining(sep));
    }

    public String join() {
        return this.join("");
    }

    public void forEachWithIndex(BiConsumer<T, Integer> consumer) {
        for (int i = 0; i < this.size(); i++) {
            consumer.accept(get(i), i);
        }
    }


}
