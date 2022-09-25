package pl.pjwstk.app.components;


import pl.pjwstk.app.events.UpgradeSelectedEvent;
import pl.pjwstk.app.events.UpgradeSelectedListener;
import pl.pjwstk.app.models.dto.PrimaryUpgrade;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UpgradesHub extends JPanel {
    private JList<String> upgradesList1;
    private JButton selectPrimaryUpgradeBtn;
    private UpgradeSelectedListener upgradeSelectedListener;

    public UpgradesHub(String name) throws HeadlessException {
        super();

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        Border innerBorder = BorderFactory.createTitledBorder(name);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;

        DefaultListModel<String> upgradeModel = createUpgradeModelOptions();
        upgradesList1 = new JList<>(upgradeModel);
        upgradesList1.setBorder(BorderFactory.createCompoundBorder(outerBorder, BorderFactory.createTitledBorder("Primary")));
        add(upgradesList1, gc);

        gc.gridx = 0;
        gc.gridy = 1;

        selectPrimaryUpgradeBtn = new JButton("Activate Upgrade");
        selectPrimaryUpgradeBtn.addActionListener((e) -> {
            int selectedPrimaryUpgradeIndex = upgradesList1.getSelectedIndex();
            String selectedValue = upgradesList1.getSelectedValue();

            UpgradeSelectedEvent upgradeSelectedEvent = new UpgradeSelectedEvent(this, new PrimaryUpgrade(selectedPrimaryUpgradeIndex, selectedValue));

            if (upgradeSelectedListener != null) {
                upgradeSelectedListener.upgradeSelectedEventOccurred(upgradeSelectedEvent);
            }
        });

        add(selectPrimaryUpgradeBtn, gc);


    }

    private DefaultListModel<String> createUpgradeModelOptions() {
        DefaultListModel<String> upgradeModel = new DefaultListModel<>();
        upgradeModel.add(0, "Brak reakcji");
        upgradeModel.add(1, "Drukowanie pieniędzy");
        upgradeModel.add(2, "Lockdown");
        upgradeModel.add(3, "Masowe szczepienia");
        upgradeModel.add(4, "Budowa szpitali");
        upgradeModel.add(5, "Refundacja do leków");
        upgradeModel.add(6, "Kampania TV");
        upgradeModel.add(7, "Inwestycje w służbę zdrowia");
        upgradeModel.add(8, "Zakrywanie twarzy");
        return upgradeModel;
    }

    public JList<String> getUpgradesList1() {
        return upgradesList1;
    }

    public void setUpgradesList1(JList<String> upgradesList1) {
        this.upgradesList1 = upgradesList1;
    }

    public void setUpgradeSelectedListener(UpgradeSelectedListener upgradeSelectedListener) {
        this.upgradeSelectedListener = upgradeSelectedListener;
    }
}
