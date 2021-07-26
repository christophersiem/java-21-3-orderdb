package de.neuefische.orderdb.db;

import de.neuefische.orderdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDbTest {

    @Test
    @DisplayName("listProducts should return all available Products")
    public void testListProducts(){

        //Given
        List<Product> products = List.of(
                new Product("1", "beer"),
                new Product("2", "apple"),
                new Product("3", "tomato")
        );
        ProductDb productDb = new ProductDb(products);

        //When
        List<Product> actual =  productDb.listProducts();

        //Then
        assertEquals(List.of(
                new Product("1", "beer"),
                new Product("2", "apple"),
                new Product("3", "tomato")
        ), actual);

    }

}