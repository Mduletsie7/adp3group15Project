/**
 * JobController.java
 * This is the Job Controller
 * @author Mdumisi Kelvin Letsie - 220120137
 * 11 August 2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Job;
import za.ac.cput.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/create")
    public Job create(@RequestBody Job job) {
        return jobService.create(job);
    }

    @GetMapping("/read/{id}")
    public Job read(@PathVariable String id) {
        return jobService.read(id);
    }

    @PostMapping("/update")
    public Job update(@RequestBody Job job) {
        return jobService.update(job);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return jobService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Job> getAll() {
        return jobService.getAll();
    }
}
