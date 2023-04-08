/**
 * JobFactoryTest.java
 * This is the JobFactoryTest Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Job;
import za.ac.cput.domain.Service;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JobFactoryTest {

    // i. Object Equality Test
    @Test
    public void test_JobEquality() {
        Job job1 = JobFactory.createJob("","","","", "");
        String jobNo = job1.getJobNo().toString();
        assertEquals(job1.getJobNo(), jobNo);
    }

    // ii. Object Identity Test
    @Test
    public void test_ObjectIdentity() {
        Job job1 = JobFactory.createJob("","","","", "");
        Job job2 = job1;
        Job job3 = JobFactory.createJob("","","","", "");

        assertSame(job1, job3);
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