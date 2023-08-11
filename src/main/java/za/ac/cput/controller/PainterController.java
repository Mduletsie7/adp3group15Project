/**
 * PainterController.java
 * This is the Painter Controller
 * @author Mdumisi Kelvin Letsie - 220120137
 * 09 August 2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Painter;
import za.ac.cput.service.PainterService;

import java.util.List;

@RestController
@RequestMapping("/painter")
public class PainterController {
    @Autowired
    private PainterService painterService;

    @PostMapping("/create")
    public Painter create(@RequestBody Painter painter) {
        return painterService.create(painter);
    }

    @GetMapping("/read/{id}")
    public Painter read(@PathVariable String id) {
        return painterService.read(id);
    }

    @PostMapping("/update")
    public Painter update(@RequestBody Painter painter) {
        return painterService.update(painter);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return painterService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Painter> getAll() {
        return painterService.getAll();
    }

}


