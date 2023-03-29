package zad2;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListCreator<T> {
    List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Predicate<T> predicate) {
        this.list = this.list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return this;
    }

    public <U> List<U> mapEvery(Function<T, U> fun) {
        return this.list.stream()
                .map(fun)
                .collect(Collectors.toList());
    }
}
