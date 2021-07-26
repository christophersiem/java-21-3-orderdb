package de.neuefische.orderdb.model;

import java.util.List;
import java.util.Objects;

public class Order {
    private final String id;
    private final List<Product> products;

    public Order(String id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", products=" + products +
                '}';
    }
}
