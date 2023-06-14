package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.PaintInventory;
import za.ac.cput.factory.PaintInventoryFactory;
import za.ac.cput.repository.impl.PaintInventoryRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class PaintInventoryRepositoryTest {
    private static PaintInventoryRepository paintRepository = PaintInventoryRepository.getPaintInventoryRepository();
    private static PaintInventory paintInventory = PaintInventoryFactory.createInventory("black15","10 buckets", "2 buckets");

    @Test
    void a_create() {
        PaintInventory paint = paintRepository.create(paintInventory);
        assertEquals(paintInventory.getColorId(), paint.getColorId());
        System.out.println("Paint bought: " + paint);
    }

    @Test
    void b_read() {
        PaintInventory paint = paintRepository.read(paintInventory.getColorId());
        assertNotNull(paint);
        System.out.println("Paint available " + paint);
    }

    @Test
    void c_update() {
        PaintInventory paintInventory1 = new PaintInventory.Builder().copy(paintInventory)
                .setColorId("red005")
                .setTransHistory("20 buckets")
                .setAmtAvailable("3 buckets")
                .build();
        assertNotNull(paintRepository.update(paintInventory1));
        System.out.println("Updated: " + paintInventory1);
    }

    @Test
    void e_delete() {
        boolean success = paintRepository.delete(paintInventory.getColorId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(paintRepository.getAll());
    }
}