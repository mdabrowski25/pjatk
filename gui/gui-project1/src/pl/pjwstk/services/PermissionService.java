package pl.pjwstk.services;

import pl.pjwstk.models.people.Person;

public class PermissionService {
    private Person loggedUser;

    public Person getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Person loggedUser) {
        this.loggedUser = loggedUser;
    }
}
