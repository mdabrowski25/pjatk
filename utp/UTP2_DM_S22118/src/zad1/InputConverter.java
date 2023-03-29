package zad1;

import java.util.function.Function;

public class InputConverter<T> {
    T arg;

    public InputConverter(T arg) {
        this.arg = arg;
    }

    public <R> R convertBy(Function... functions) {
        Object arg = this.arg;
        Object result = null;

        for (Function fun: functions) {
            result = fun.apply(arg);
            arg = result;
        }

        return (R) result;
    }
}
