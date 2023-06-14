package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;
import za.ac.cput.repository.impl.SupplierRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierRepositoryTest {
    private static SupplierRepository supplierRepository = SupplierRepository.getSupplierRepository();
    private static Supplier supplier = SupplierFactory.createSupplier("com12366", "26565", "com@gmail.com", "123Abc");
    @Test
    void a_create(){
        Supplier created = supplierRepository.create(supplier);
        assertEquals(supplier.getSupplierId(), created.getSupplierId());
        System.out.println("Supplier: " + created);
    }
    @Test
    void b_read(){
        Supplier supplier1 = supplierRepository.read(supplier.getSupplierId());
        assertNotNull(supplier1);
        System.out.println("SupplierId: " + supplier1);
    }
    @Test
    void  c_update(){
        Supplier supplier1Updated = new Supplier.Builder().copy(supplier).setSupplierId("abc123")
                .setCompanyName("abc12366")
                .setPhoneNumber("023156")
                .setEmailAddress("abc@gmail.com")
                .setPickupAddress("08 nowanga str")
                .build();
        assertNotNull(supplierRepository.update(supplier1Updated));
        System.out.println("Updated: " + supplier1Updated);
    }
    @Test
    void e_delete(){
        Boolean success = supplierRepository.delete(supplier.getSupplierId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
    @Test
    void d_getAll(){
        System.out.println("Show all: ");
        System.out.println(supplierRepository.getAll());
    }

}