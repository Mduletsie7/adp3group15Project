package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Painter;
import za.ac.cput.factory.PainterFactory;
import za.ac.cput.service.PainterService;

import java.util.Set;

@RestController
public class PainterController {
    @Autowired
    private PainterService painterService;

//    @RequestMapping(value = "/create", method = RequestMethod.POST) Longer way of doing it
    @PostMapping("/createPainter")
    public Painter create(@RequestBody Painter painter) {
        Painter painterCreated = PainterFactory.createPainter(
                painter.getFirstName(),
                painter.getLastName(),
                painter.getAddress(),
                painter.getEmail(),
                painter.getPhoneNumber());
        return painterService.create(painterCreated);
    }

    @RequestMapping({"/getAllPainter"})
    public Set<Painter> getAll() {
        return painterService.getAll();
    }
}
