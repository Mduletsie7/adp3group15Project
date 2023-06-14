package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.SuppPickupAddress;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SuppPickupAddressFactoryTest {
    //1. Testing Object identity
    @Test
    public void testSuppPickupAddress() {
        SuppPickupAddress pickupAddress1 = SuppPickupAddressFactory.createPickupAddress("08 nowanga str", "com12366");
        SuppPickupAddress pickupAddress2 = pickupAddress1;
        SuppPickupAddress pickupAddress3 = SuppPickupAddressFactory.createPickupAddress("10 nowanga str", "abc55465");
        assertNotSame(pickupAddress3, pickupAddress1);
    }
    //2. Testing Object Equality
    @Test
    public void testPickupAddress(){
        SuppPickupAddress pickupAddress = SuppPickupAddressFactory.createPickupAddress("08 nowanga str", "com");
        String suppPickup = pickupAddress.getAddressId().toString();
        assertSame(pickupAddress.getAddressId(), "");
    }
    //3. Failing test
    @Test
    public void failingTests(){
        SuppPickupAddress pickupAddress = SuppPickupAddressFactory.createPickupAddress("","");
        assertNotNull(pickupAddress);
        System.out.println(pickupAddress.getSuppAddressId());
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