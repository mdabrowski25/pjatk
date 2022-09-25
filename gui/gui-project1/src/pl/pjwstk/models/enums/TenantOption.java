package pl.pjwstk.models.enums;

import pl.pjwstk.exceptions.NoSuchOptionException;

public enum TenantOption {
    EXIT(0,"Exit program"),
    LOGOUT(1, "Logout"),
    REPAIR(2, "Left the car in the service");

    private final int id;
    private final String description;

    TenantOption(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static TenantOption createFromInt(int option) throws NoSuchOptionException {
        try {
            return TenantOption.values()[option];
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
