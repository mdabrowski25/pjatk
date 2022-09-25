package pl.pjwstk.exceptions;

public class NeverRentException extends Exception {
    public NeverRentException() {
    }

    public NeverRentException(String message) {
        super(message);
    }
}
