package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Consultant;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ConsultantFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class ConsultantRepositoryTest {

    private static ConsultantRepository repository = ConsultantRepository.getRepository();
    private static Consultant consultant = ConsultantFactory.createConsultant("Lerato", "Moshabi", "0817666452", "lm@gmail.com", "WC");
    @Test
    void a_create() {
        Consultant created = repository.create(consultant);
        assertEquals(consultant.getConsultantId(), created.getConsultantId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Consultant read = repository.read(consultant.getConsultantId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Consultant updated = new Consultant.Builder().copy(consultant).setFirstName("9826")
                .setLastName("Marylin Street")
                .setPhoneNumber("Wellington")
                .setEmail("7856")
                .setAddress("EC")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(consultant.getConsultantId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}