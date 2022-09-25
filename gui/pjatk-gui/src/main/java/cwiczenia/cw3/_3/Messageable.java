package cwiczenia.cw3._3;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Messageable {
    void sendMessage();

    default List<Message> getMessages() {
        return new ArrayList<>();
    }
}
