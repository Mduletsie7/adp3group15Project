package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Job;
import za.ac.cput.factory.JobFactory;
import za.ac.cput.service.JobService;

import java.util.Set;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    //    @RequestMapping(value = "/create", method = RequestMethod.POST) Longer way of doing it
    @PostMapping("/createJob")
    public Job create(@RequestBody Job job) {
        Job jobCreated = JobFactory.createJob(
                job.getQuote(),
                job.getStartDate(),
                job.getEndDate(),
                job.getInvoiceNo(),
                job.getPainterId());
        return jobService.create(jobCreated);
    }

    @RequestMapping({"/getAllJob"})
    public Set<Job> getAll() {
        return jobService.getAll();
    }
}

