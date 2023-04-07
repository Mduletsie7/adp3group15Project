package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Service;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {
    Service service = new Service();

    // i. Object Equality Test
    @Test
    public void test_ServiceEquality() {
        Service service1 = ServiceFactory.createService("Roof Painting");
        String serviceId = service1.getServiceId().toString();
        assertEquals(service1.getServiceId(), serviceId);
    }

    // ii. Object Identity Test
    @Test
    public void test_ObjectIdentity() {
        Service service1 = ServiceFactory.createService("Roof Painting");
        Service service2 = service1;
        Service service3 = ServiceFactory.createService("Wall Painting");

        assertSame(service1, service3);
    }

    // iii. Product build Failing TEST
    @Test
    public void test_fail() {
        Service service1 = ServiceFactory.createService("");
        assertNotNull(service1);
        System.out.println(service1.toString());
    }

    // iv. Timeout Test
    @Test
    void test_TimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("Execution exceeded timeout duration!");
        });
    }

    // v. Disabling Test
    @Disabled("TODO: Still need to code this method")
    @Test
    public void test_productInTransit() {
    }
}