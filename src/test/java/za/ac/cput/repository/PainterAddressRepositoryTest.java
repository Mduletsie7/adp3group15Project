/**
 * PainterAddressRepositoryTest.java
 * This is the PainterAddressRepositoryTest Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.PainterAddress;
import za.ac.cput.factory.PainterAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class PainterAddressRepositoryTest {
    private static PainterAddressRepository painterAddressRepository = PainterAddressRepository.getRepository();
    private static PainterAddress painterAddress = PainterAddressFactory.createPainterAddress("0005394","004403");

    @Test
    void a_create() {
        PainterAddress created = painterAddressRepository.create(painterAddress);
        assertEquals(painterAddress.getPainterAddressId(), created.getPainterAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        PainterAddress read = painterAddressRepository.read(painterAddress.getPainterAddressId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        PainterAddress updated = new PainterAddress.Builder().copy(painterAddress).setAddressId("000001")
                .build();
        assertNotNull(painterAddressRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = painterAddressRepository.delete(painterAddress.getPainterAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(painterAddressRepository.getAll());
    }
}