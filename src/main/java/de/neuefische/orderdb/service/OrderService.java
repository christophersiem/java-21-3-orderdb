package de.neuefische.orderdb.service;

import de.neuefische.orderdb.db.OrderDb;
import de.neuefische.orderdb.db.ProductDb;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderService {
    private final ProductDb productDb;
    private final OrderDb orderDb;

    public OrderService(ProductDb productDb, OrderDb orderDb) {
        this.productDb = productDb;
        this.orderDb = orderDb;
    }

    public Order orderProducts(List<String> productIds) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> optionalProduct = productDb.getProductById(productId);
            if (optionalProduct.isPresent()) {
                productsToOrder.add(optionalProduct.get());
            } else {
                throw new IllegalArgumentException("Product with ID " + productId + " does not exist");
            }
        }
        String id = UUID.randomUUID().toString();
        return orderDb.addOrder(new Order(id, productsToOrder));
    }



}
