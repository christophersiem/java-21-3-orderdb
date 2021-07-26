package de.neuefische.orderdb.service;

import de.neuefische.orderdb.db.OrderDb;
import de.neuefische.orderdb.db.ProductDb;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    @DisplayName("orderProducts returns new Order")
    public void testOrderProducts() {
        //Given
        List<Product> products = List.of(
                new Product("1", "beer"),
                new Product("2", "apple"),
                new Product("3", "tomato")
        );
        ProductDb productDb = new ProductDb(products);
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(productDb, orderDb);

        //When
        Order actual = orderService.orderProducts(List.of("1", "3"));

        //Then
        List<Product> expected = List.of(
                new Product("1", "beer"),
                new Product("3", "tomato")
        );
        assertEquals(expected, actual.getProducts());
        assertNotNull(actual.getId());
    }

    @Test
    @DisplayName("order non existing Product should throw Exception")
    public void orderNonExistingProduct() {
        //Given
        List<Product> products = List.of(
                new Product("1", "beer"),
                new Product("2", "apple"),
                new Product("3", "tomato")
        );
        ProductDb productDb = new ProductDb(products);
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(productDb, orderDb);

        try {
            //When
            orderService.orderProducts(List.of("4"));
            fail();
        } catch (IllegalArgumentException actual) {
            //Then
            assertEquals("Product with ID 4 does not exist", actual.getMessage());

        }
    }

}