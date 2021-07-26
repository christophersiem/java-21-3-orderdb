package de.neuefische.orderdb.service;

import de.neuefische.orderdb.db.OrderDb;
import de.neuefische.orderdb.db.ProductDb;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;

import java.util.ArrayList;
import java.util.List;
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
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        String id = UUID.randomUUID().toString();
        return orderDb.addOrder(new Order(id, productsToOrder));
    }

    private Product getProduct(String productId) {
        return productDb.getProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " does not exist"));
    }


    public List<Order> listOrders() {
        return orderDb.listOrders();
    }

}
