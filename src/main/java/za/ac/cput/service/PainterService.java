package za.ac.cput.service;

import za.ac.cput.domain.Painter;

import java.util.Set;

public interface PainterService extends IService <Painter, String> {

    Set<Painter> getAll();
}
