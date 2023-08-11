/**
 * JobService.java
 * This is the JobService Interface
 * @author Mdumisi Kelvin Letsie - 220120137
 * 11 August 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.Job;

import java.util.List;

public interface JobService extends IService <Job, String> {
    List<Job> getAll();
}
