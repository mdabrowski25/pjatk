package pl.pjwstk.app.components;



import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    private JLabel activePrimaryUpgrade;
    private JLabel credits;
    private JLabel maxCredits;


    public Toolbar(Integer creditsInitValue, Integer maxCreditsInitValue) {
        super();


        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        JLabel primeUpgradeLabel = new JLabel("Active primary upgrade:");
        add(primeUpgradeLabel, gc);

        gc.gridx = 1;

        activePrimaryUpgrade = new JLabel("None");
        add(activePrimaryUpgrade, gc);

        gc.gridx = 0;
        gc.gridy = 1;

        add(new JLabel("Available credits:"), gc);

        gc.gridx = 1;

        credits = new JLabel(creditsInitValue.toString());
        add(credits, gc);

        gc.gridy = 2;
        gc.gridx = 0;


        add(new JLabel("Max credits:"), gc);

        gc.gridx = 1;

        maxCredits = new JLabel(maxCreditsInitValue.toString());
        add(maxCredits, gc);
    }

    public JLabel getActivePrimaryUpgrade() {
        return activePrimaryUpgrade;
    }

    public void setActivePrimaryUpgrade(String activePrimaryUpgradeText) {
        this.activePrimaryUpgrade.setText(activePrimaryUpgradeText);
    }

    public JLabel getCredits() {
        return credits;
    }

    public JLabel getMaxCredits() {
        return maxCredits;
    }

    public void updateCredits(Integer amount){
        credits.setText(amount.toString());
    }
    public void updateMaxCredits(Integer amount){
        maxCredits.setText(amount.toString());
    }
}
