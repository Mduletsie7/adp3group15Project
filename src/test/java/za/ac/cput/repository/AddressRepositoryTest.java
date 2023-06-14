/**
 * AddressRepositoryTest.java
 * This is the AddressRepositoryTest Class
 * @author Lerato Moshabi - 220076073
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class AddressRepositoryTest {
    private static AddressRepository addressRepository = AddressRepository.getRepository();
    private static Address address = AddressFactory.createAddress("22","St.Mark Street","Paarl","7655","Western Cape");
    @Test
    void a_create() {
        Address created = addressRepository.create(address);
        assertEquals(address.getAddressId(), created.getAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Address read = addressRepository.read(address.getAddressId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setStreetNumber("8975")
                .setStreetNane("Mandela Street")
                .build();
        assertNotNull(addressRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = addressRepository.delete(address.getAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(addressRepository.getAll());
    }
}