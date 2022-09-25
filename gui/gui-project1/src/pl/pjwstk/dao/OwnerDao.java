package pl.pjwstk.dao;

import pl.pjwstk.exceptions.NoSuchPersonException;
import pl.pjwstk.models.people.Owner;
import pl.pjwstk.models.people.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OwnerDao implements Dao<Owner>{
    private List<Owner> owners = new ArrayList<>();

    @Override
    public Owner get(Integer id) throws NoSuchPersonException {
        return owners.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchPersonException::new);
    }

    @Override
    public List<Owner> getAll() {
        return owners;
    }

    @Override
    public void save(Owner owner) {
        owners.add(owner);
    }

    @Override
    public void update(Owner owner, Owner newOwner) throws NoSuchPersonException {
        Integer id = owners.stream()
                .filter(el -> el.equals(owner))
                .map(Person::getId).findFirst()
                .orElseThrow(NoSuchPersonException::new);
        owners.set(id - 1, newOwner);
    }

    @Override
    public void delete(Integer id) throws NoSuchPersonException {
        if (owners.get(id) == null) {
            throw new NoSuchPersonException();
        }
        owners = owners.stream()
                .filter(el -> !el.getId().equals(id))
                .collect(Collectors.toList());
    }
}
