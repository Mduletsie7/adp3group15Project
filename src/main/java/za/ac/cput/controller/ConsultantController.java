/**
 * ConsultantController.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.Job;
import za.ac.cput.service.ConsultantService;
import za.ac.cput.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {
    @Autowired
    private ConsultantService consultantService;

    @PostMapping("/create")
    public Consultant create(@RequestBody Consultant consultant) {
        return consultantService.create(consultant);
    }

    @GetMapping("/read/{id}")
    public Consultant read(@PathVariable String id) {
        return consultantService.read(id);
    }

    @PostMapping("/update")
    public Consultant update(@RequestBody Consultant consultant) {
        return consultantService.update(consultant);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return consultantService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Consultant> getAll() {
        return consultantService.getAll();
    }
}
