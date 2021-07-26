package de.neuefische.orderdb.db;

import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDbTest {

    @Test
    @DisplayName("listOrders should return all available Orders")
    public void testListOrders() {
        //Given
        OrderDb orderDb = new OrderDb();
        orderDb.addOrder(new Order("1", List.of(
                new Product("1", "beer"),
                new Product("2", "apple")
        )));
        orderDb.addOrder(new Order("2", List.of(
                new Product("1", "beer"),
                new Product("3", "tomato")
        )));

        //When
        List<Order> actual = orderDb.listOrders();

        //Then
        List<Order> expected = List.of(
                new Order("1", List.of(
                        new Product("1", "beer"),
                        new Product("2", "apple")
                )),
                new Order("2", List.of(
                        new Product("1", "beer"),
                        new Product("3", "tomato")
                )));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addOrder should add Order to orderdb")
    public void testAdd() {
        //Given
        OrderDb orderDb = new OrderDb();
        Order newOrder = new Order("1", List.of(
                new Product("1", "beer"),
                new Product("2", "apple")
        ));

        //When
        orderDb.addOrder(newOrder);

        //Then
        assertTrue(orderDb.listOrders().contains(
                new Order("1", List.of(
                        new Product("1", "beer"),
                        new Product("2", "apple")
                ))));


    }
}