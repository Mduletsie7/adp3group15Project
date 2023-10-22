package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Supplier Factory test, it tests if supplier factory works fine
 * due date: 22/10/2023
 * */
class SupplierFactoryTest {
    //1. Testing Object identity
    @Test
    public void testSupplierIdentity(){
        Supplier supplier1 = SupplierFactory.createSupplier("companyABC", "0545641", "abc@gmail.com", "08 nowanga str");
        Supplier supplier2 = supplier1;
        Supplier supplier3 = SupplierFactory.createSupplier("xyz", "886545", "xyz@gmail.com", "10 zonnebloem str");
        assertNotSame(supplier3, supplier1);
    }
    //2. Testing Object Equality
    @Test
    public void testSupplierEquality(){
        Supplier supplier = SupplierFactory.createSupplier("companyABC", "26546", "abc@gmail.com", "10 Zonnebloem str");
        String supplier2 = supplier.getCompanyName();
        assertEquals(supplier.getCompanyName(), supplier2);
    }
    //3. Failing test
    @Test
    public void failingTests(){
        Supplier supplier = SupplierFactory.createSupplier("companyABC", "0988732", "abc@gmail.com", "08 nowanga str");
        assertNotNull(supplier);
        System.out.println(supplier.toString());
    }
    //4. Testing Timeouts
    @Test
    public void test_TimeOut(){
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