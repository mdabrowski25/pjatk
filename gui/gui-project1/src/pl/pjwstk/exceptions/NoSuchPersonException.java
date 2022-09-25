package pl.pjwstk.exceptions;

public class NoSuchPersonException extends Exception {
    public NoSuchPersonException() {
    }

    public NoSuchPersonException(String message) {
        super(message);
    }
}
