package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.SuppPickupAddress;
import za.ac.cput.factory.SuppPickupAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SuppPickupAddressRepositoryTest {
    private static SuppPickupAddressRepository suppPickupAddressRepository = SuppPickupAddressRepository.getSuppPickupAddressRepository();
    private static SuppPickupAddress suppPickupAddress = SuppPickupAddressFactory.createPickupAddress("now123", "com123");
    @Test
    void a_create(){
       SuppPickupAddress suppPickupAddress1 = suppPickupAddressRepository.create(suppPickupAddress);
       assertEquals(suppPickupAddress.getSuppAddressId(), suppPickupAddress1.getSuppAddressId());
       System.out.println("Pickup address" + suppPickupAddress1);
    }
    @Test
    void b_read(){
        SuppPickupAddress suppPickupAddress1 = suppPickupAddressRepository.read(suppPickupAddress.getSuppAddressId());
        assertNotNull(suppPickupAddress1);
        System.out.println("pickup address: " + suppPickupAddress1);
    }
    @Test
    void c_update(){
        SuppPickupAddress suppPickupAddress1 = new SuppPickupAddress.Builder().copy(suppPickupAddress)
                .setSuppAddressId("546542")
                .setAddressId("abc123")
                .setSupplierId("com12366")
                .build();
        assertNotNull(suppPickupAddressRepository.update(suppPickupAddress1));
        System.out.println("Updated: " + suppPickupAddress1);
    }
    @Test
    void e_delete(){
        Boolean success = suppPickupAddressRepository.delete(suppPickupAddress.getSuppAddressId());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }
    @Test
    void d_getAll(){
        System.out.println("Show all: ");
        System.out.println(suppPickupAddressRepository.getAll());
    }
}
