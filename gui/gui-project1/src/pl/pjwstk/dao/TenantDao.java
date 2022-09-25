package pl.pjwstk.dao;

import pl.pjwstk.exceptions.NoSuchPersonException;
import pl.pjwstk.models.people.Person;
import pl.pjwstk.models.people.Tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TenantDao implements Dao<Tenant> {
    private List<Tenant> tenants = new ArrayList<>();

    public TenantDao() {
    }

    @Override
    public Tenant get(Integer id) throws NoSuchPersonException {
        return tenants.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchPersonException::new);
    }

    @Override
    public List<Tenant> getAll() {
        return tenants;
    }

    @Override
    public void save(Tenant tenant) {
        tenants.add(tenant);
    }

    @Override
    public void update(Tenant tenant, Tenant newTenant) throws NoSuchPersonException {
        Integer id = tenants.stream()
                .filter(el -> el.equals(tenant))
                .map(Person::getId).findFirst()
                .orElseThrow(NoSuchPersonException::new);
        tenants.set(id - 1, newTenant);
    }

    @Override
    public void delete(Integer id) throws NoSuchPersonException {
        if (tenants.get(id) == null) {
            throw new NoSuchPersonException();
        }
        tenants = tenants.stream()
                .filter(el -> !el.getId().equals(id))
                .collect(Collectors.toList());
    }
}
