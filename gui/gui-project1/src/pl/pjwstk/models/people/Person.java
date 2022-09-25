package pl.pjwstk.models.people;

import pl.pjwstk.alerts.TenantAlert;
import pl.pjwstk.models.enums.Permission;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String pesel;
    private String address;
    private Permission permission;
    private TenantAlert tenantAlert;



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public TenantAlert getTenantAlert() {
        return tenantAlert;
    }

    public void setTenantAlert(TenantAlert tenantAlert) {
        this.tenantAlert = tenantAlert;
    }

    @Override
    public String toString() {
        return " | Person: " +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", pesel='" + pesel + '\'' +
                ", address='" + address + '\'' +
                ", permission=" + permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(pesel, person.pesel) && Objects.equals(address, person.address) && permission == person.permission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, dateOfBirth, pesel, address, permission);
    }
}

