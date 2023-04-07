/**
 * PainterRepository.java
 * This is the PainterRepository POJO
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Painter;
import java.util.HashSet;
import java.util.Set;

public class PainterRepository implements IPainterRepository {
    private static PainterRepository painterRepository = null;
    private Set<Painter> painterDB = null;

    private PainterRepository(){
        painterDB = new HashSet<Painter>();
    }

    public static PainterRepository getRepository(){
        if(painterRepository == null) {
            painterRepository = new PainterRepository();
        }
        return painterRepository;
    }

    @Override
    public Painter create(Painter painter) {
        boolean success = painterDB.add(painter);
        if (!success){
            return null;
        }
        return painter;
    }

    @Override
    public Painter read(String painterId) {
        // Lambda expressions Java 8
        Painter painter = painterDB.stream()
                .filter(e -> e.getFirstName().equals(painterId))
                .findAny()
                .orElse(null);
        return painter;
    }

    @Override
    public Painter update(Painter painter) {
        Painter oldPainter = read(painter.getPainterId());
        if (oldPainter != null){
            painterDB.remove(oldPainter);
            painterDB.add(painter);
            return painter;
        }
        return null;
    }

    @Override
    public boolean delete(String painterId) {
        Painter painterToDelete = read(painterId);
        if (painterToDelete == null){
            return false;
        }
        painterDB.remove(painterToDelete);
        return true;
    }

    @Override
    public Set<Painter> getAll() {
        return painterDB;
    }
}
