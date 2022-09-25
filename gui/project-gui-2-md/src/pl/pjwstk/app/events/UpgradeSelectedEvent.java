package pl.pjwstk.app.events;

import pl.pjwstk.app.models.dto.PrimaryUpgrade;

import java.util.EventObject;

public class UpgradeSelectedEvent extends EventObject {
    private PrimaryUpgrade primaryUpgrade;

    public UpgradeSelectedEvent(Object source) {
        super(source);
    }

    public UpgradeSelectedEvent(Object source, PrimaryUpgrade primaryUpgradeObject) {
        super(source);
        this.primaryUpgrade = primaryUpgradeObject;
    }

    public PrimaryUpgrade getPrimaryUpgrade() {
        return primaryUpgrade;
    }

    public void setPrimaryUpgrade(PrimaryUpgrade primaryUpgrade) {
        this.primaryUpgrade = primaryUpgrade;
    }
}
