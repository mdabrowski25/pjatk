package pl.pjwstk.dao;

import pl.pjwstk.models.warehouses.ConsumerWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ConsumerWarehouseDao implements Dao<ConsumerWarehouse> {
    List<ConsumerWarehouse> consumerWarehouses = new ArrayList<>();

    @Override
    public ConsumerWarehouse get(Integer id) throws NoSuchElementException {
        return consumerWarehouses.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ConsumerWarehouse> getAll() {
        return consumerWarehouses;
    }

    @Override
    public void save(ConsumerWarehouse consumerWarehouse) {
        consumerWarehouses.add(consumerWarehouse);
    }

    @Override
    public void update(ConsumerWarehouse consumerWarehouse, ConsumerWarehouse newConsumerWarehouse) throws NoSuchElementException {
        Integer id = consumerWarehouses.stream()
                .filter(el -> el.equals(consumerWarehouse))
                .map(ConsumerWarehouse::getId).findFirst()
                .orElseThrow(NoSuchElementException::new);
        consumerWarehouses.set(id - 1, newConsumerWarehouse);
    }

    @Override
    public void delete(Integer id) throws NoSuchElementException {
        if (consumerWarehouses.get(id - 1) == null) {
            throw new NoSuchElementException();
        }
        consumerWarehouses = consumerWarehouses.stream()
                .filter(el -> !el.getId().equals(id))
                .collect(Collectors.toList());
    }
}
