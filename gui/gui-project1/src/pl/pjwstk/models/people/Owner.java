package pl.pjwstk.models.people;

import pl.pjwstk.alerts.TenantAlert;
import pl.pjwstk.models.departments.Service;
import pl.pjwstk.models.enums.Permission;
import pl.pjwstk.services.CheckerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Owner extends Person {
    private List<Service> servicesOwned;

    @Override
    public String toString() {
        return super.toString() +
                ", servicesOwned=" + servicesOwned + " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(servicesOwned, owner.servicesOwned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), servicesOwned);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final CheckerService checkerService = new CheckerService();

        private Integer id;
        private String firstname;
        private String lastname;
        private LocalDate dateOfBirth;
        private String pesel;
        private String address;
        private List<Service> servicesOwned;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder pesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder servicesOwned(List<Service> servicesOwned) {
            this.servicesOwned = servicesOwned;
            return this;
        }

        public Owner build() {
            checkerService.checkPersonBuilderProperties(id, firstname, lastname, dateOfBirth, address, pesel);
            Owner owner = new Owner();
            owner.setFirstname(this.firstname);
            owner.setLastname(this.lastname);
            owner.setDateOfBirth(this.dateOfBirth);
            owner.setPesel(this.pesel);
            owner.setAddress(this.address);
            owner.setPermission(Permission.OWNER);
            owner.setId(this.id);

            if (this.servicesOwned != null) {
                owner.servicesOwned = this.servicesOwned;
            }
            return owner;
        }

    }
}
