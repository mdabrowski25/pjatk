package pl.pjwstk.app.components.main;

import pl.pjwstk.app.components.CountryPanel;
import pl.pjwstk.app.components.Toolbar;
import pl.pjwstk.app.components.UpgradesHub;
import pl.pjwstk.app.events.LoserInit;
import pl.pjwstk.app.events.SavePlayerInit;
import pl.pjwstk.app.models.dto.PrimaryUpgrade;
import pl.pjwstk.app.services.GameEqService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {
    public static Integer time = 0;
    CountryPanel polandCountryPanel;
    CountryPanel czechCountryPanel;
    CountryPanel germanyCountryPanel;
    CountryPanel ukCountryPanel;
    CountryPanel usaCountryPanel;
    CountryPanel russiaCountryPanel;
    Toolbar toolbar;
    UpgradesHub upgradesHub;
    PrimaryUpgrade activePrimaryUpgrade;
    JButton refresh;
    GameEqService gameEqService;
    Timer timer;

    public GameFrame() throws HeadlessException {
        super();
        gameEqService = new GameEqService();
        activePrimaryUpgrade = new PrimaryUpgrade(0, "Brak reakcji");
        polandCountryPanel = new CountryPanel("Poland", "src/pl/pjwstk/app/images/polando.svg.png", 100);
        czechCountryPanel = new CountryPanel("Czech", "src/pl/pjwstk/app/images/czechrepublic.svg.png", 100);
        germanyCountryPanel = new CountryPanel("Germany", "src/pl/pjwstk/app/images/germany.svg.png", 100);
        ukCountryPanel = new CountryPanel("UK", "src/pl/pjwstk/app/images/uk.svg.png", 100);
        usaCountryPanel = new CountryPanel("USA", "src/pl/pjwstk/app/images/usflag.png", 100);
        russiaCountryPanel = new CountryPanel("Russia", "src/pl/pjwstk/app/images/russia.svg.png", 100);
        toolbar = new Toolbar(gameEqService.availableCredits, gameEqService.maxCredits);
        upgradesHub = new UpgradesHub("Upgrades");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridy = 1;

        upgradesHub.setUpgradeSelectedListener(e -> {
            PrimaryUpgrade primaryUpgrade = e.getPrimaryUpgrade();

            this.activePrimaryUpgrade = primaryUpgrade;

            toolbar.setActivePrimaryUpgrade(primaryUpgrade.getName());
        });

        add(toolbar, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(polandCountryPanel, gc);
        gc.gridx = 2;
        add(czechCountryPanel, gc);
        gc.gridx = 3;
        add(germanyCountryPanel, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(ukCountryPanel, gc);
        gc.gridx = 2;
        add(usaCountryPanel, gc);
        gc.gridx = 3;
        add(russiaCountryPanel, gc);

        gc.anchor = GridBagConstraints.PAGE_START;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 0.5;
        add(upgradesHub, gc);


        basicConfig();

        timer = new Timer(1000,this);
        timer.start();
    }


    private void basicConfig() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(1080, 600);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time++;
        if (gameEqService.availableCredits <= 0) {
            new LoserInit().actionPerformed(e);
            this.dispose();
            timer.stop();
        }
        if (polandCountryPanel.getInfected() <= 0) {
            new SavePlayerInit().actionPerformed(e);
            this.dispose();
            timer.stop();
        }
        switch (activePrimaryUpgrade.getIndex()) {
            case 0:
                gameEqService.availableCredits -= 10;
                toolbar.updateCredits(gameEqService.availableCredits);
                break;
            case 1:
                gameEqService.availableCredits += 100;
                gameEqService.maxCredits -= 200;
                toolbar.updateCredits(gameEqService.availableCredits);
                toolbar.updateMaxCredits(gameEqService.maxCredits);
                break;
            case 2:
                gameEqService.availableCredits -= 100;
                toolbar.updateCredits(gameEqService.availableCredits);
                break;
            case 3:
                polandCountryPanel.setInfected(polandCountryPanel.getInfected() - 1);
                polandCountryPanel.updateInfectedCount();
                break;
            case 4:
                gameEqService.availableCredits -= 1000;
                polandCountryPanel.setInfected(polandCountryPanel.getInfected() - 5);
                toolbar.updateCredits(gameEqService.availableCredits);
                polandCountryPanel.updateInfectedCount();
                break;
            case 5:
                gameEqService.availableCredits -= 500;
                polandCountryPanel.setInfected(polandCountryPanel.getInfected() - 2);
                toolbar.updateCredits(gameEqService.availableCredits);
                polandCountryPanel.updateInfectedCount();
                break;
            case 6:
                gameEqService.availableCredits -= 1500;
                toolbar.updateCredits(gameEqService.availableCredits);
                break;
            case 7:
                gameEqService.availableCredits -= 1500;
                polandCountryPanel.setInfected(polandCountryPanel.getInfected() - 2);
                toolbar.updateCredits(gameEqService.availableCredits);
                polandCountryPanel.updateInfectedCount();
                break;
            case 8:
                gameEqService.availableCredits += 10;
                polandCountryPanel.setInfected(polandCountryPanel.getInfected() - 2);
                toolbar.updateCredits(gameEqService.availableCredits);
                polandCountryPanel.updateInfectedCount();
                break;

        }
    }
}
