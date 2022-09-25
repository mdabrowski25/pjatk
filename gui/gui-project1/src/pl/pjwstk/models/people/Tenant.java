package pl.pjwstk.models.people;

import pl.pjwstk.alerts.TenantAlert;
import pl.pjwstk.exceptions.NeverRentException;
import pl.pjwstk.models.enums.Permission;
import pl.pjwstk.models.warehouses.ConsumerWarehouse;
import pl.pjwstk.services.CheckerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Tenant extends Person {
    private LocalDate dateOfFirstRent;
    private List<ConsumerWarehouse> warehousesOwned;

    public LocalDate getDateOfFirstRent() throws NeverRentException {
        if (dateOfFirstRent == null) {
            throw new NeverRentException();
        }
        return dateOfFirstRent;
    }

    public List<ConsumerWarehouse> getWarehousesOwned() {
        return warehousesOwned;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", dateOfFirstRent=" + dateOfFirstRent +
                ", warehousesOwned=" + warehousesOwned + " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(dateOfFirstRent, tenant.dateOfFirstRent) && Objects.equals(warehousesOwned, tenant.warehousesOwned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfFirstRent, warehousesOwned);
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
        private LocalDate dateOfFirstRent;
        private List<ConsumerWarehouse> warehousesOwned;

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

        public Builder dateOfFirstRent(LocalDate dateOfFirstRent) {
            this.dateOfFirstRent = dateOfFirstRent;
            return this;
        }

        public Builder warehousesOwned(List<ConsumerWarehouse> warehousesOwned) {
            this.warehousesOwned = warehousesOwned;
            return this;
        }

        public Tenant build() {
            checkerService.checkPersonBuilderProperties(this.id, this.firstname, this.lastname, this.dateOfBirth,
                    this.address, this.pesel);

            Tenant tenant = new Tenant();
            tenant.setFirstname(this.firstname);
            tenant.setLastname(this.lastname);
            tenant.setDateOfBirth(this.dateOfBirth);
            tenant.setPesel(this.pesel);
            tenant.setAddress(this.address);
            tenant.setPermission(Permission.TENANT);
            tenant.setId(this.id);

            if (this.dateOfFirstRent != null) {
                tenant.dateOfFirstRent = this.dateOfFirstRent;
            }
            if (this.warehousesOwned != null) {
                tenant.warehousesOwned = this.warehousesOwned;
            }
            tenant.setTenantAlert(TenantAlert.NONE);
            return tenant;
        }
    }

}
