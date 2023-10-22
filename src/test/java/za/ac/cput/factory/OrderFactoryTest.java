package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Orders;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Factory test, it checks if the order factory works fine
 * due date: 22/10/2023
 * */
public class OrderFactoryTest {

    //1. Testing for Object Identity
    @Test
    public void testOrderIdentity(){
        Orders order1 = OrderFactory.createOrder("001", "001", "10/10/2023","20/10/2023", "R5000");
        Orders order2 = order1;
        Orders order3 = OrderFactory.createOrder("001", "001", "10/10/2023", "20/10/2023", "R5000");
        assertNotSame(order3, order1);
    }
    //2. Testing for Object equality
    @Test
    public void testOrderEquality(){
        Orders order1 = OrderFactory.createOrder("001", "001", "10/10/2023", "20/10/2023", "R5000");
        String order2 = order1.getOrderId();
        assertEquals(order1.getOrderId(), order2);
    }

    //3. Testing for failing tests
    @Test
    public void failingTests(){
        Orders order = OrderFactory.createOrder("001", "001", "10/10/2023", "20/10/2023", "R5000");
        assertNotNull(order);
        System.out.println(order.toString());
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