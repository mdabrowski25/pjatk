package pl.pjwstk.repositories;

import pl.pjwstk.dao.ConsumerWarehouseDao;
import pl.pjwstk.dao.ServiceWarehouseDao;
import pl.pjwstk.models.warehouses.ConsumerWarehouse;
import pl.pjwstk.models.warehouses.ServiceWarehouse;
import pl.pjwstk.models.warehouses.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseRepository {
    public static int counter = 1;
    public static List<Warehouse> warehouses = new ArrayList<>();
    private final ConsumerWarehouseDao consumerWarehouseDao = new ConsumerWarehouseDao();
    private final ServiceWarehouseDao serviceWarehouseDao = new ServiceWarehouseDao();

    public void addServiceWarehouse(ServiceWarehouse serviceWarehouse) {
        warehouses.add(serviceWarehouse);
        serviceWarehouseDao.save(serviceWarehouse);
    }

    public void addConsumerWarehouse(ConsumerWarehouse consumerWarehouse) {
        warehouses.add(consumerWarehouse);
        consumerWarehouseDao.save(consumerWarehouse);
    }

    public List<ConsumerWarehouse> getConsumerWarehouses() {
        return consumerWarehouseDao.getAll();
    }

    public List<ServiceWarehouse> getServiceWarehouses() {
        return serviceWarehouseDao.getAll();
    }

    public List<Warehouse> getAll() {
        return warehouses;
    }
}
