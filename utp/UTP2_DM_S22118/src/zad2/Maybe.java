package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {
    private T arg;

    public Maybe() {
    }

    public Maybe(T arg) {
        this.arg = arg;
    }

    public static <T> Maybe<T> of(T arg) {
        if (arg == null) {
            return new Maybe<>();
        }
        return new Maybe<>(arg);
    }

    public void ifPresent(Consumer<T> consumer) {
        if (arg != null) {
            consumer.accept(arg);
        }
    }

    public <R> Maybe<R> map(Function<T, R> func) {
        if (arg != null) {
            return new Maybe<>(func.apply(arg));
        }
        return new Maybe<>();
    }

    public T get() {
        if (arg != null) {
            return arg;
        }
        throw new NoSuchElementException("maybe is empty");
    }

    public T orElse(T defVal) {
        if (arg != null) {
            return arg;
        }
        return defVal;
    }

    public Maybe<T> filter(Predicate<T> predicate) {
        if (arg == null) {
            return new Maybe<>();
        }
        if (predicate.test(arg)) {
            return new Maybe<>(arg);
        }
        return new Maybe<>();
    }

    @Override
    public String toString() {
        if (arg != null) {
            return "Maybe has value " + arg;
        } else {
            return "Maybe is empty";
        }
    }
}
