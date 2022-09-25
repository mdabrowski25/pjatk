package wyklady.guiBasicAppWyk1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    static class AppFrame extends Frame {
        AppFrame() throws HeadlessException {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    System.exit(0);
                    //dispose() dla okienka, System.exit() do zamkniecia calego procesu
                }
        });
            setSize(300,300);
            setLayout(null);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AppFrame();
    }
}
