/**
 * ConsultantFactoryTest.java
 * Tests ConsultantFactoryTest
 * Author: Lerato Moshabi - (220076073)
 * Date: 8 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Consultant;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ConsultantFactoryTest {
    // i. Object Equality Test
    @Test
    public void a_testCompareConsultant() {
        Consultant consultant = new Consultant();
        Consultant myConsultant = ConsultantFactory.createConsultant("Zack", "Milton", "083122658", "652@gmail.com", "12 John Street");
        String consultantDetails = myConsultant.getFirstName().toString();
        assertEquals(consultantDetails, "Jackson");
    }


    // ii. Object Identity Test
    @Test
    public void b_testObjectIdentity() {
        Consultant consultant = new Consultant();
        Consultant consultant1 = ConsultantFactory.createConsultant("Peter", "Whale", "062236285", "fd@gmail.com", "211 Sax Street");
        Consultant consultant2 =  consultant1;
        Consultant consultant3 = ConsultantFactory.createConsultant("Griffin", "Shark", "021439986", "lg@gmail.com", "186 Map Street");

        assertSame(consultant1, consultant3);
    }

    // iii. Animal build Failing TEST
    @Test
    public void c_test_fail(){
        Consultant consultant = ConsultantFactory.createConsultant("Mag", "Dog","39808928", "88@gmail.com", "969 Sharp Street");
        assertNotNull(consultant);
        System.out.println(consultant.toString());

    }

    // iv. Timeout Test
    @Test
    void d_testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("Execution exceeded timout duration!");
        });
    }

    // v. Disabling Test
}