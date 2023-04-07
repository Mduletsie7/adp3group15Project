package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class AddressRepositoryTest {
    private static AddressRepository repository = AddressRepository.getRepository();
    private static Address address = AddressFactory.createAddress("22", "Mrabaraba Street", "Paarl", "7655", "WC");
    @Test
    void a_create() {
        Address created = repository.create(address);
        assertEquals(address.getAddressId(), created.getAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Address read = repository.read(address.getAddressId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setStreetNumber("222")
                .setStreetName("Mrabaraba Streeet")
                .setCity("Paaarl")
                .setZipCode("7626")
                .setProvince("WCC")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(address.getAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}