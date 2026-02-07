package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopRepositoryTest {

    private ShopRepository sr;
    private Product product1;
    private Product product2;
    private Product product3;


    @BeforeEach
    public void setup() {
        sr = new ShopRepository();

        product1 = new Product(1, "Хлеб", 50);
        product2 = new Product(2, "Молоко", 80);
        product3 = new Product(3, "Сыр", 200);

        sr.add(product1);
        sr.add(product2);
        sr.add(product3);
    }

    @Test
    public void shouldRemoveById() throws Exception {

        Product[] productsBefore = sr.findAll();



            sr.removeById(2);


        Product[] productsAfter = sr.findAll();

        Assertions.assertEquals(2, productsAfter.length);


    }

    @Test
    public void shouldNotFoundException() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            sr.removeById(4);
        });
    }


}
