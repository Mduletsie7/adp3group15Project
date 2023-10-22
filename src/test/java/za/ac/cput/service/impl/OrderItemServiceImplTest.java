package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class OrderItemServiceImplTest {
    @Autowired
    private OrderItemServiceImpl orderItemService;
    private static final OrderItem orderItem = OrderItemFactory.createOrderItem("201", "001", "Brushes", "250", "4");
    //Creating new order objects
    @Test
    void a_create() {
        OrderItem created = orderItemService.create(orderItem);
        assertEquals(orderItem.getOrderItemId(), created.getOrderItemId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        OrderItem read = orderItemService.read(orderItem.getOrderItemId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        OrderItem orderItem1 = new OrderItem.Builder().copy(orderItem)
                .setItemOrdered("Paint")
                .build();
        OrderItem updated = orderItemService.update(orderItem1);
        assertEquals(orderItem1.getItemOrdered(), updated.getItemOrdered());
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(orderItemService.getAll());
    }

    @Test
    void e_delete() {

    }
}