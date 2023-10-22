package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    private  static final Order order = OrderFactory.createOrder("001", "001", "10/10/2023", "20/10/2023", "R5000");
    @Test
    void a_create() {
        Order created = orderService.create(order);
        assertEquals(order.getOrderId(), created.getOrderId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Order read = orderService.read(order.getOrderId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Order order1 = new Order.Builder().copy(order)
                .setOrderId("004")
                .build();
        Order updated = orderService.update(order1);
        assertEquals(order1.getOrderId(), updated.getOrderId());
        System.out.println("updated: " + updated);
    }
    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(orderService.getAll());
    }
    @Test
    void e_delete() {
    }
}