/**
 * ProjectServiceImpl.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Project;
import za.ac.cput.repository.IProjectRepository;
import za.ac.cput.service.ProjectService;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    private IProjectRepository repository;

    @Autowired
    private ProjectServiceImpl(IProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Project create(Project project) {
        return this.repository.save(project);
    }

    @Override
    public Project read(String projectId) {
        return this.repository.findById(projectId).orElse(null);
    }

    @Override
    public Project update(Project project) {
        if (this.repository.existsById(project.getProjectId()))
            return this.repository.save(project);
        return null;
    }

    @Override
    public boolean delete(String projectId) {
        if (this.repository.existsById(projectId)) {
            this.repository.deleteById(projectId);
            return true;
        }
        return false;
    }

    @Override
    public List<Project> getAll() {
        return this.repository.findAll();
    }
}
