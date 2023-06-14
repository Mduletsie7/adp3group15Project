/**
 * ConsultantAddressRepositoryTest.java
 * This is the ConsultantAddressRepositoryTest Class
 * @author Lerato Moshabi - 220076073
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ConsultantAddress;
import za.ac.cput.factory.ConsultantAddressFactory;
import za.ac.cput.repository.impl.ConsultantAddressRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class ConsultantAddressRepositoryTest {
    private static ConsultantAddressRepository consultantAddressRepository = ConsultantAddressRepository.getRepository();
    private static ConsultantAddress consultantAddress = ConsultantAddressFactory.createConsultantAddress("323", "rfr");

    @Test
    void a_create() {
        ConsultantAddress created = consultantAddressRepository.create(consultantAddress);
        assertEquals(consultantAddress.getConsultantAddressId(), created.getConsultantAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        ConsultantAddress read = consultantAddressRepository.read(consultantAddress.getConsultantAddressId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        ConsultantAddress updated = new ConsultantAddress.Builder().copy(consultantAddress).setConsultantId("82782")
                .build();
        assertNotNull(consultantAddressRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        boolean success = consultantAddressRepository.delete(consultantAddress.getConsultantAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll() {
        System.out.println("Show all:");
        System.out.println(consultantAddressRepository.getAll());
    }
}