/**
 * PainterAddressFactoryTest.java
 * This is the PainterAddressFactoryTest Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PainterAddress;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PainterAddressFactoryTest {
    // i. Object Equality Test
    @Test
    public void test_PainterAddressEquality() {
        PainterAddress painterAddress1 = PainterAddressFactory.createPainterAddress("","");
        String painterAddressId = painterAddress1.getPainterAddressId().toString();
        assertEquals(painterAddress1.getPainterAddressId(), painterAddressId);
    }

    // ii. Object Identity Test
    @Test
    public void test_ObjectIdentity() {
        PainterAddress painterAddress1 = PainterAddressFactory.createPainterAddress("","");
        PainterAddress painterAddress2 = painterAddress1;
        PainterAddress painterAddress3 = PainterAddressFactory.createPainterAddress("","");

        assertSame(painterAddress1, painterAddress3);
    }

    // iii. Product build Failing TEST
    @Test
    public void test_fail() {
        PainterAddress painterAddress1 = PainterAddressFactory.createPainterAddress("","");
        assertNotNull(painterAddress1);
        System.out.println(painterAddress1.toString());
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