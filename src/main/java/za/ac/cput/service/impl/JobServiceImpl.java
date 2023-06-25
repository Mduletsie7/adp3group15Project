package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Job;
import za.ac.cput.repository.impl.JobRepository;
import za.ac.cput.service.JobService;

import java.util.Set;

@Service
public class JobServiceImpl implements JobService {

    private static JobServiceImpl service = null;

    private static JobRepository repository = null;

    private JobServiceImpl() { repository = JobRepository.getRepository(); }

    public static JobServiceImpl getService() {
        if (service == null) {
            service = new JobServiceImpl();
        }
        return service;
    }

    @Override
    public Job create(Job job) {
        Job created = repository.create(job);
        return created;
    }

    public Job read(String jobNo) {
        Job readJob = repository.read(jobNo);
        return readJob;
    }

    public Job update(Job job) {
        Job updated = repository.update(job);
        return updated;
    }

    public boolean delete(String jobNo) {
        boolean success = repository.delete(jobNo);
        return success;
    }

    public Set<Job> getAll() {return repository.getAll();}
}

