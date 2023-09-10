package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PaintInventory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PaintInventoryFactoryTest {
    //1. Testing Object identity
    @Test
    public void testPaintInventoryIdentity(){
        PaintInventory paint1 = PaintInventoryFactory.createInventory("White12","10 buckets", "1 and a half");
        PaintInventory paint2 = paint1;
        PaintInventory paint3 = PaintInventoryFactory.createInventory("Black10","15 buckets", "2 buckets");
        assertNotSame(paint1, paint3);
    }
    //2. Testing Object Equality
    @Test
    public void testPaintInventoryEquality(){
        PaintInventory paintInventory = PaintInventoryFactory.createInventory("White7", "20 Buckets", "3 buckets");
        String myPaint = paintInventory.getTransHistory().toString();
        assertEquals(paintInventory.getTransHistory(), myPaint);
    }
    //3. Failing test
    @Test
    public void failingTests(){
        PaintInventory paintInventory = PaintInventoryFactory.createInventory("Black3","10 buckets", "3 buckets");
        assertNotNull(paintInventory);
        System.out.println(paintInventory.toString());
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