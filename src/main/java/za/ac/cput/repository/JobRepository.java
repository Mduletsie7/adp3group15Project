/**
 * JobRepository.java
 * This is the JobRepository Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Job;

import java.util.HashSet;
import java.util.Set;


public class JobRepository implements IJobRepository{
    private static JobRepository jobRepository = null;
    private Set<Job> jobDB = null;

    private JobRepository(){
        jobDB = new HashSet<Job>();
    }

    public static JobRepository getRepository(){
        if(jobRepository == null) {
            jobRepository = new JobRepository();
        }
        return jobRepository;
    }

    @Override
    public Job create(Job job) {
        boolean success = jobDB.add(job);
        if (!success){
            return null;
        }
        return job;
    }

    @Override
    public Job read(String jobNo) {
        // Lambda expressions Java 8
        Job job = jobDB.stream()
                .filter(j -> j.getJobNo().equals(jobNo))
                .findAny()
                .orElse(null);
        return job;
    }

    @Override
    public Job update(Job job) {
        Job oldJob = read(job.getJobNo());
        if (oldJob != null){
            jobDB.remove(oldJob);
            jobDB.add(job);
            return job;
        }
        return null;
    }

    @Override
    public boolean delete(String jobNo) {
        Job jobToDelete = read(jobNo);
        if (jobToDelete == null){
            return false;
        }
        jobDB.remove(jobToDelete);
        return true;
    }

    @Override
    public Set<Job> getAll() {
        return jobDB;
    }
}
