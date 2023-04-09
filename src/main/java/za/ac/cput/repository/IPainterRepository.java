package za.ac.cput.repository;

import za.ac.cput.domain.Painter;

import java.util.Set;

public interface IPainterRepository extends IRepository<Painter, String>{
    // create, read, update, delete
    public Set<Painter> getAll();
}
