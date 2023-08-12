/**
 * PainterService.java
 * This is the PainterService Interface
 * @author Mdumisi Kelvin Letsie - 220120137
 * 09 August 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.Painter;

import java.util.List;

public interface PainterService extends IService <Painter, String> {

    List<Painter> getAll();
}
