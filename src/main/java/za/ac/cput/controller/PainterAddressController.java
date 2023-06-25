package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.PainterAddress;
import za.ac.cput.factory.PainterAddressFactory;
import za.ac.cput.service.PainterAddressService;

import java.util.Set;

@RestController
public class PainterAddressController {
    @Autowired
    private PainterAddressService painterAddressService;

    @PostMapping("/createPainterAddress")
    public PainterAddress create(@RequestBody PainterAddress painterAddress) {
        PainterAddress painterAddressCreated = PainterAddressFactory.createPainterAddress(
                painterAddress.getPainterId(),
                painterAddress.getPainterAddressId());
        return painterAddressService.create(painterAddressCreated);
    }

    @RequestMapping({"/getAllPainterAddress"})
    public Set<PainterAddress> getAll() {
        return painterAddressService.getAll();
    }
}

