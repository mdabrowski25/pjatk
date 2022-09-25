package pl.pjwstk.repositories;

import pl.pjwstk.dao.OwnerDao;
import pl.pjwstk.dao.TenantDao;
import pl.pjwstk.exceptions.NoSuchPersonException;
import pl.pjwstk.models.people.Owner;
import pl.pjwstk.models.people.Person;
import pl.pjwstk.models.people.Tenant;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public static int counter = 1;
    public static List<Person> people = new ArrayList<>();
    private OwnerDao ownerDao = new OwnerDao();
    private TenantDao tenantDao = new TenantDao();

    public List<Owner> getAllOwners() {
        return ownerDao.getAll();
    }

    public void addOwner(Owner owner) {
        people.add(owner);
        ownerDao.save(owner);
    }

    public List<Tenant> getAllTenants() {
        return tenantDao.getAll();
    }

    public void addTenant(Tenant tenant) {
        people.add(tenant);
        tenantDao.save(tenant);
    }


    public Person checkPersonAndReturn(Integer id) throws NoSuchPersonException {
        return people.get(id-1);
    }

    public List<Person> getAll() {
        return people;
    }
}
