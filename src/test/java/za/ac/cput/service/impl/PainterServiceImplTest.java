package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Painter;
import za.ac.cput.factory.PainterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PainterServiceImplTest {
    @Autowired
    private PainterServiceImpl service;

    private static Painter painter = PainterFactory.createPainter("Thabo", "Mokoena", "0219136627", "mokoenat@outlook.com", "5 Burgsville Rd", "Cape Town", "Western Cape", "9225","A good painter");

    @Test
    void a_create() {
        Painter created = service.create(painter);
        assertEquals(painter.getPainterId(), created.getPainterId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Painter read = service.read(painter.getPainterId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Painter newPainter = new Painter.Builder().copy(painter).setFirstName("Thabo James").build();
        Painter updated = service.update(newPainter);
        assertEquals(newPainter.getFirstName(), updated.getFirstName());
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(service.getAll());
    }

    @Test
    @Disabled
    void delete() {
    }

}