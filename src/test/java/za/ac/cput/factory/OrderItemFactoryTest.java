package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Item factory Test and its tests if the factory method works fine
 * due date: 22/10/2023
 * */
class OrderItemFactoryTest {
    //1. Testing for Object Identity
    @Test
    public void testOrderItemIdentity(){
        OrderItem orderItem = OrderItemFactory.createOrderItem("201", "001", "Brushes", "250", "4");
        OrderItem orderItem1 = orderItem;
        OrderItem orderItem2 = OrderItemFactory.createOrderItem("201", "001", "Brushes", "250", "4");
        assertNotSame(orderItem, orderItem2);
    }
    //2. Testing for object Equality
    @Test
    public void testOrderItemEquality(){
        OrderItem orderItem = OrderItemFactory.createOrderItem("201", "001", "Brushes","250", "4");
        String orderItem2 = orderItem.getOrderItemId();
        assertEquals(orderItem.getOrderItemId(), orderItem2);
    }
    //3. Testing for failing tests
    @Test
    public void failingTest(){
        OrderItem orderItem = OrderItemFactory.createOrderItem("201", "001", "Brushes", "250", "4");
        assertNotNull(orderItem);
        System.out.println(orderItem.toString());
    }
    //4. Testing timeouts
    @Test
    public void timeoutTest(){
        assertTimeout(Duration.ofMillis(100), () ->{
            Thread.sleep(60);
            System.out.println("Execution exceeded timeout duration...");
        });
    }
    //5. Disabling tests
    @Disabled
    @Test
    public void disablingTest(){

    }

}