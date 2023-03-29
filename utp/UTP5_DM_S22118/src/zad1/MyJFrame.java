package zad1;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    String name;

    public MyJFrame(String name) {
        super();
        this.name = name;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,600));
        this.setTitle(name);

    }
}
