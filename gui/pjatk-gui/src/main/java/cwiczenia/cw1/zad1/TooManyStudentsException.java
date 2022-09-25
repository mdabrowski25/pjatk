package cwiczenia.cw1.zad1;

public class TooManyStudentsException extends Exception {
    public TooManyStudentsException() {
    }

    public TooManyStudentsException(String message) {
        super(message);
    }
}
