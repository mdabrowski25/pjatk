/**
 *
 *  @author Dąbrowski Mateusz S22118
 *
 */

package zad1;


import java.util.List;
import java.util.stream.Collectors;

public class ListCreator<T> {
    List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    ListCreator<T> when(Selector<T> sel) {
        this.list = this.list.stream()
                .filter(sel::select)
                .collect(Collectors.toList());
        return this;
    }

    <U> List<U> mapEvery(Mapper<T, U> map) {
        return this.list.stream()
                .map(map::map)
                .collect(Collectors.toList());
    }
}  
