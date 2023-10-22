/**
 * PainterServiceImpl.java
 * This is the PainterServiceImpl Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 09 August 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Painter;
import za.ac.cput.repository.IPainterRepository;
import za.ac.cput.service.PainterService;

import java.util.List;

@Service
public class PainterServiceImpl implements PainterService {

    private IPainterRepository repository;

    @Autowired
    private PainterServiceImpl(IPainterRepository repository) {
        this.repository = repository; }


    @Override
    public Painter create(Painter painter) {
        return this.repository.save(painter);
    }

    @Override
    public Painter read(String painterId) {
        return this.repository.findById(painterId).orElse(null);
    }

    @Override
    public Painter update(Painter painter) {
        if (this.repository.existsById(painter.getPainterId()))
            return this.repository.save(painter);
        return null;
    }

    @Override
    public boolean delete(String painterId) {
        if (this.repository.existsById(painterId)) {
            this.repository.deleteById(painterId);
            return true;
        }
        return false;
    }

    @Override
    public List<Painter> getAll() {
        return this.repository.findAll();
    }
}
