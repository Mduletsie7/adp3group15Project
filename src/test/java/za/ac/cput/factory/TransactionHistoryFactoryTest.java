package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TransactionHistory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static za.ac.cput.factory.TransactionHistoryFactory.createInvoice;

class TransactionHistoryFactoryTest {

    // 1. Testing Object equality
    @Test
    public void test_transactionHistory(){
        TransactionHistory invoice1 = TransactionHistoryFactory.createInvoice("12366", "com12366", "04/08/2023", "R15000" );
        String invoice2 = invoice1.getTransNo().toString();
        assertEquals(invoice1.getTransNo(), invoice2);
    }

    //2. Testing Object Identity
    @Test
    public  void transHistoryIdentity(){
        TransactionHistory invoice1 = TransactionHistoryFactory.createInvoice("","com12366", "04/08/2023", "15000");
        TransactionHistory invoice2 = invoice1;
        TransactionHistory invoice3 = TransactionHistoryFactory.createInvoice("",  "com12366", "04/08/2023", "15000");
        assertNotSame(invoice1, invoice3);
    }
    //3. Testing fail tests
    @Test
    public void failTest(){
        TransactionHistory transactionHistory = TransactionHistoryFactory.createInvoice("", "", "", "");
        assertNotNull(transactionHistory);
        System.out.println(transactionHistory.toString());
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