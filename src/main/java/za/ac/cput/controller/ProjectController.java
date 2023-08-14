package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Job;
import za.ac.cput.domain.Project;
import za.ac.cput.service.JobService;
import za.ac.cput.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public Project create(@RequestBody Project job) {
        return projectService.create(job);
    }

    @GetMapping("/read/{id}")
    public Project read(@PathVariable String id) {
        return projectService.read(id);
    }

    @PostMapping("/update")
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return projectService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Project> getAll() {
        return projectService.getAll();
    }
}
