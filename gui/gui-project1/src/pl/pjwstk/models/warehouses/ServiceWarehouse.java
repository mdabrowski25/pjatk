package pl.pjwstk.models.warehouses;

import pl.pjwstk.models.people.Person;
import pl.pjwstk.services.CheckerService;

import java.util.List;

public class ServiceWarehouse extends Warehouse {
    private Person possessor;
    private List<Person> permittedPeople;


    public Person getPossessor() {
        return possessor;
    }

    public void setPossessor(Person possessor) {
        this.possessor = possessor;
    }

    @Override
    public List<Person> getPermittedPeople() {
        return permittedPeople;
    }

    @Override
    public void setPermittedPeople(List<Person> permittedPeople) {
        this.permittedPeople = permittedPeople;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final CheckerService checkerService = new CheckerService();

        private Integer id;
        private int height;
        private int lengthA;
        private int lengthB;
        private List<Person> permittedPeople;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder lengthA(int lengthA) {
            this.lengthA = lengthA;
            return this;
        }

        public Builder lengthB(int lengthB) {
            this.lengthB = lengthB;
            return this;
        }

        public Builder permittedPeople(List<Person> permittedPeople) {
            this.permittedPeople = permittedPeople;
            return this;
        }

        public ServiceWarehouse build() {
            checkerService.checkServiceWarehouseBuilderProperties(this.id, this.height, this.lengthA, this.lengthB);
            ServiceWarehouse serviceWarehouse = new ServiceWarehouse();
            serviceWarehouse.setId(this.id);
            serviceWarehouse.setHeight(this.height);
            serviceWarehouse.setLengthA(this.lengthA);
            serviceWarehouse.setLengthB(this.lengthB);
            serviceWarehouse.setCapacity(this.lengthA * this.lengthB * this.height);
            if (this.permittedPeople != null) {
                serviceWarehouse.setPermittedPeople(this.permittedPeople);
            }
            return serviceWarehouse;
        }
    }
}
