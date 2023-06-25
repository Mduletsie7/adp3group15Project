package za.ac.cput.service;

import za.ac.cput.domain.Job;

import java.util.Set;

public interface JobService extends IService <Job, String> {
    Set<Job> getAll();
}
