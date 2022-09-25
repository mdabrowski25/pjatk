package pl.pjwstk.dao;


import pl.pjwstk.models.warehouses.ServiceWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ServiceWarehouseDao implements Dao<ServiceWarehouse> {
    List<ServiceWarehouse> serviceWarehouses = new ArrayList<>();

    @Override
    public ServiceWarehouse get(Integer id) throws NoSuchElementException {
        return serviceWarehouses.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ServiceWarehouse> getAll() {
        return serviceWarehouses;
    }

    @Override
    public void save(ServiceWarehouse serviceWarehouse) {
        serviceWarehouses.add(serviceWarehouse);
    }

    @Override
    public void update(ServiceWarehouse serviceWarehouse, ServiceWarehouse newServiceWarehouse) throws NoSuchElementException {
        Integer id = serviceWarehouses.stream()
                .filter(el -> el.equals(serviceWarehouse))
                .map(ServiceWarehouse::getId).findFirst()
                .orElseThrow(NoSuchElementException::new);
        serviceWarehouses.set(id - 1, newServiceWarehouse);
    }

    @Override
    public void delete(Integer id) throws NoSuchElementException {
        if (serviceWarehouses.get(id - 1) == null) {
            throw new NoSuchElementException();
        }
        serviceWarehouses = serviceWarehouses.stream()
                .filter(el -> !el.getId().equals(id))
                .collect(Collectors.toList());
    }
}
