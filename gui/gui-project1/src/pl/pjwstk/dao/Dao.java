package pl.pjwstk.dao;

import pl.pjwstk.exceptions.NoSuchPersonException;

import java.util.List;

public interface Dao<T> {
    T get(Integer id) throws NoSuchPersonException;

    List<T> getAll();

    void save(T t);

    void update(T t, T t2) throws NoSuchPersonException;

    void delete(Integer id) throws NoSuchPersonException;
}
