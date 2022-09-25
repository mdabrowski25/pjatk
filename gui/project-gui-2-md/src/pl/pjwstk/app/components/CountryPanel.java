package pl.pjwstk.app.components;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CountryPanel extends JPanel {
    private ImageIcon icon;
    private JLabel infectedCount;
    private int infected = 100;

    public CountryPanel(String name, String path, double height) {
        super();

        this.icon = new ImageIcon(path);

        double prop = height / this.icon.getIconHeight();
        this.icon = new ImageIcon(icon.getImage()
                .getScaledInstance((int) (icon.getIconWidth() * prop), (int) (height), Image.SCALE_SMOOTH));

        this.setPreferredSize(new Dimension(icon.getIconWidth()+50, this.icon.getIconHeight()+10));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        Border innerBorder = BorderFactory.createTitledBorder(name);
        setBorder(innerBorder);

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.weighty = 1;
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 0;


        infectedCount = new JLabel();
        infectedCount.setOpaque(true);
        infectedCount.setBackground(Color.BLACK);
        infectedCount.setForeground(Color.white);
        infectedCount.setVerticalAlignment(SwingConstants.TOP);
        infectedCount.setText(String.valueOf(this.infected));
        add(infectedCount, gc);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        icon.paintIcon(this, g, 50, 10);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public JLabel getInfectedCount() {
        return infectedCount;
    }

    public void setInfectedCount(JLabel infectedCount) {
        this.infectedCount = infectedCount;
    }

    public void updateInfectedCount() {
        infectedCount.setText(String.valueOf(this.infected));
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }
}
