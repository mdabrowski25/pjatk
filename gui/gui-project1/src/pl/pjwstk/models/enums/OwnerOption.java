package pl.pjwstk.models.enums;

import pl.pjwstk.exceptions.NoSuchOptionException;

public enum OwnerOption {
    EXIT(0,"Exit program"),
    LOGOUT(1, "Logout"),
    TENANTLIST(2, "Show Tenant list"),
    SHOWSERVICECARSPOTS(3, "Show service car spots states");

    private final int id;
    private final String description;

    OwnerOption(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static OwnerOption createFromInt(int option) throws NoSuchOptionException {
        try {
            return OwnerOption.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Brak opcji o ID: " + option);
        }
    }

    @Override
    public String toString() {
        return id +
                ": " + description;
    }
}
