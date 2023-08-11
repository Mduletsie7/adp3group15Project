/**
 * JobServiceImpl.java
 * This is the JobServiceImpl Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 11 August 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Job;
import za.ac.cput.repository.IJobRepository;
import za.ac.cput.service.JobService;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private IJobRepository repository;

    @Autowired
    private JobServiceImpl(IJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job create(Job job) {
        return this.repository.save(job);
    }

    @Override
    public Job read(String jobId) {
        return this.repository.findById(jobId).orElse(null);
    }

    @Override
    public Job update(Job job) {
        if (this.repository.existsById(job.getJobId()))
            return this.repository.save(job);
        return null;
    }

    @Override
    public boolean delete(String jobId) {
        if (this.repository.existsById(jobId)) {
            this.repository.deleteById(jobId);
            return true;
        }
        return false;
    }

    @Override
    public List<Job> getAll() {
        return this.repository.findAll();
    }
}
