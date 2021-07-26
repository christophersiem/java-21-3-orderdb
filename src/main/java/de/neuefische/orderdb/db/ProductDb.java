package de.neuefische.orderdb.db;

import de.neuefische.orderdb.model.Product;

import java.util.Collections;
import java.util.List;

public class ProductDb {

    private final List<Product> products;

    public ProductDb(List<Product> products) {
        this.products = Collections.unmodifiableList(products);
    }

    public List<Product> listProducts() {
        return products;
    }
}
