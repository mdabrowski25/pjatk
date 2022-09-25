package pl.pjwstk.app.events;

import java.util.EventListener;

public interface UpgradeSelectedListener extends EventListener {
    void upgradeSelectedEventOccurred(UpgradeSelectedEvent e);
}
