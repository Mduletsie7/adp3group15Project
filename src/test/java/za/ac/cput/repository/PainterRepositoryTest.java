package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Painter;
import za.ac.cput.factory.PainterFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PainterRepositoryTest {
    private static PainterRepository painterRepository = PainterRepository.getRepository();
    private static Painter painter = PainterFactory.createPainter("John","Doe","4 Loxton Road","JohnDoe@hireme.com","0819153260");
    @Test
    void a_create() {
        Painter created = painterRepository.create(painter);
        assertEquals(painter.getPainterId(), created.getPainterId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Painter read = painterRepository.read(painter.getPainterId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Painter updated = new Painter.Builder().copy(painter).setFirstName("Jonathan")
                .setEmail("Dorian")
                .build();
        assertNotNull(painterRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = painterRepository.delete(painter.getPainterId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(painterRepository.getAll());
    }
}