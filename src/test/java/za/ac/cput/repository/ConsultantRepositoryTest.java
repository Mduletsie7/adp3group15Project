package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Consultant;
import za.ac.cput.factory.ConsultantFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class ConsultantRepositoryTest {

    private static ConsultantRepository consultantRepository = ConsultantRepository.getRepository();
    private static Consultant consultant = ConsultantFactory.createConsultant("Shaun","Powell","73 Pixel Street","SPowell@gmail.com","0215783698");
    @Test
    void a_create() {
        Consultant created = consultantRepository.create(consultant);
        assertEquals(consultant.getConsultantId(), created.getConsultantId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Consultant read = consultantRepository.read(consultant.getConsultantId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Consultant updated = new Consultant.Builder().copy(consultant).setFirstName("Aman")
                .setEmail("Natt@gmail.com")
                .build();
        assertNotNull(consultantRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = consultantRepository.delete(consultant.getConsultantId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(consultantRepository.getAll());
    }
}