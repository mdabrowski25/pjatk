/**
 * @author Dąbrowski Mateusz S22118
 */

package zad2;


import java.util.List;
import java.util.Objects;

public class Purchase implements Comparable<Purchase> {
    String id;
    String customer;
    String product;
    Double price;
    Double quantity;

    public Purchase(List<String> listOfArgs) {
        this.id = listOfArgs.get(0);
        this.customer = listOfArgs.get(1);
        this.product = listOfArgs.get(2);
        this.price = Double.parseDouble(listOfArgs.get(3));
        this.quantity = Double.parseDouble(listOfArgs.get(4));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer parsedId() {
        return Integer.parseInt(this.id.substring(1));
    }

    @Override
    public int compareTo(Purchase o) {
        if (this.customer.compareTo(o.customer) < 0) {
            return -1;
        } else if (this.customer.compareTo(o.customer) > 0) {
            return 1;
        } else {
            return Integer.compare(this.parsedId().compareTo(o.parsedId()), 0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id) && Objects.equals(customer, purchase.customer) && Objects.equals(product, purchase.product) && Objects.equals(price, purchase.price) && Objects.equals(quantity, purchase.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, product, price, quantity);
    }

    @Override
    public String toString() {
        return id + ";"
                + customer + ";" + product + ";" + price +
                ";" + quantity;
    }
}
