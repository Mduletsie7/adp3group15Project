package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class SupplierServiceImplTest {
    @Autowired
    private SupplierServiceImpl supplierService;
    private static final Supplier supplier = SupplierFactory.createSupplier("ABC", "08451513532", "abc@gmail.com", "08 Nowanga Street Khayelitsha");
    @Test
    void a_create() {
        Supplier created = supplierService.create(supplier);
        assertEquals(supplier.getCompanyName(), created.getCompanyName());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Supplier read = supplierService.read(supplier.getCompanyName());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Supplier supplier1 = new Supplier.Builder().copy(supplier)
                .setCompanyName("XYZ")
                .build();
        Supplier updated = supplierService.update(supplier1);
        assertEquals(supplier1.getCompanyName(), updated.getCompanyName());
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(supplierService.getAll());
    }

    @Test
    void e_delete() {
    }
}