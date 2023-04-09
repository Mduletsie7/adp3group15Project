/**
 * ServiceRepositoryTest.java
 * This is the ServiceRepositoryTest Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Service;
import za.ac.cput.factory.ServiceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ServiceRepositoryTest {
    private static ServiceRepository serviceRepository = ServiceRepository.getRepository();
    private static Service service = ServiceFactory.createService("Roof Painting");
    @Test
    void a_create() {
        Service created = serviceRepository.create(service);
        assertEquals(service.getServiceId(), created.getServiceId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Service read = serviceRepository.read(service.getServiceId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Service updated = new Service.Builder().copy(service).setServiceName("Wooden frame painting")
                .build();
        assertNotNull(serviceRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = serviceRepository.delete(service.getServiceId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(serviceRepository.getAll());
    }
}