package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Painter;
import za.ac.cput.repository.impl.PainterRepository;
import za.ac.cput.service.PainterService;

import java.util.Set;

@Service
public class PainterServiceImpl implements PainterService {

    private static PainterServiceImpl service = null;

    private static PainterRepository repository = null;

    private PainterServiceImpl() { repository = PainterRepository.getRepository(); }

    public static  PainterServiceImpl getService() {
        if (service == null) {
            service = new PainterServiceImpl();
        }
        return service;
    }

    @Override
    public Painter create(Painter painter) {
        Painter created = repository.create(painter);
        return created;
    }

    public Painter read(String painterId) {
        Painter readPainter = repository.read(painterId);
        return readPainter;
    }

    public Painter update(Painter painter) {
        Painter updated = repository.update(painter);
        return updated;
    }

    public boolean delete(String painterId) {
        boolean success = repository.delete(painterId);
        return success;
    }

    public Set<Painter> getAll() {return repository.getAll();}
}
