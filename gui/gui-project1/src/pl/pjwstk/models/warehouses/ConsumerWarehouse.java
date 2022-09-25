package pl.pjwstk.models.warehouses;

import pl.pjwstk.models.people.Person;
import pl.pjwstk.services.CheckerService;

import java.util.List;

public class ConsumerWarehouse extends Warehouse {
    private Person possessor;
    private List<Person> permittedPeople;


    public Person getPossessor() {
        return possessor;
    }

    public void setPossessor(Person possessor) {
        this.possessor = possessor;
    }

    @Override
    public void setPermittedPeople(List<Person> permittedPeople) {
        this.permittedPeople = permittedPeople;
    }

    @Override
    public List<Person> getPermittedPeople() {
        return permittedPeople;
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
        private Person possessor;
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

        public Builder possessor(Person possessor) {
            this.possessor = possessor;
            return this;
        }

        public ConsumerWarehouse build() {
            checkerService.checkConsumerWarehouseBuilderProperties(this.id, this.height, this.lengthA, this.lengthB);
            ConsumerWarehouse consumerWarehouse = new ConsumerWarehouse();
            consumerWarehouse.setId(this.id);
            consumerWarehouse.setHeight(this.height);
            consumerWarehouse.setLengthA(this.lengthA);
            consumerWarehouse.setLengthB(this.lengthB);
            consumerWarehouse.setCapacity(this.lengthA * this.lengthB * this.height);
            consumerWarehouse.setId(this.id);
            consumerWarehouse.setPossessor(this.possessor);
            if (this.permittedPeople != null) {
                consumerWarehouse.setPermittedPeople(this.permittedPeople);
            }
            return consumerWarehouse;
        }
    }
}
