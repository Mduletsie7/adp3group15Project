/**
 * JobRepositoryTest.java
 * This is the JobRepositoryTest Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 08 April 2023
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Job;
import za.ac.cput.factory.JobFactory;
import za.ac.cput.repository.impl.JobRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class JobRepositoryTest {

    private static JobRepository jobRepository = JobRepository.getRepository();
    private static Job job = JobFactory.createJob("q23015","23.04.2021","23.06.2022","000123","0005394");
    @Test
    void a_create() {
        Job created = jobRepository.create(job);
        assertEquals(job.getJobNo(), created.getJobNo());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Job read = jobRepository.read(job.getJobNo());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Job updated = new Job.Builder().copy(job).setEndDate("23.20.2024")
                .build();
        assertNotNull(jobRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = jobRepository.delete(job.getJobNo());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(jobRepository.getAll());
    }
}