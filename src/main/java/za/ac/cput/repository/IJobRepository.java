package za.ac.cput.repository;

import za.ac.cput.domain.Job;

import java.util.Set;

public interface IJobRepository extends IRepository<Job, String>{
    public Set<Job> getAll();
}
