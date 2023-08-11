/**
 * ConsultantAddressFactoryTest.java
 * Tests ConsultantAddressFactoryTest
 * Author: Lerato Moshabi - (220076073)
 * Date: 8 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ConsultantAddress;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ConsultantAddressFactoryTest {
    // i. Object Equality Test
    @Test
    public void test_ConsultantAddressEquality() {
        ConsultantAddress consultantAddress1 = ConsultantAddressFactory.createConsultantAddress("2982","26824");
        String consultantAddressId = consultantAddress1.getConsultantAddressId().toString();
        assertEquals(consultantAddress1.getConsultantAddressId(), consultantAddressId);
    }

    // ii. Object Identity Test
    @Test
    public void test_ObjectIdentity() {
        ConsultantAddress consultantAddress1 = ConsultantAddressFactory.createConsultantAddress("618","368");
        ConsultantAddress consultantAddress2 = consultantAddress1;
        ConsultantAddress consultantAddress3 = ConsultantAddressFactory.createConsultantAddress("68","17");

        assertSame(consultantAddress1, consultantAddress3);
    }

    // iii. Product build Failing TEST
    @Test
    public void test_fail() {
        ConsultantAddress consultantAddress1 = ConsultantAddressFactory.createConsultantAddress("2983","936");
        assertNotNull(consultantAddress1);
        System.out.println(consultantAddress1.toString());
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