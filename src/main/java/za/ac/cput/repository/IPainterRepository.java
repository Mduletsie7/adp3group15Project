/**
 * IPainterRepository.java
 * This is the PainterRepository Interface
 * @author Mdumisi Kelvin Letsie - 220120137
 * 09 August 2023
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Painter;

@Repository
public interface IPainterRepository extends JpaRepository<Painter, String> {

}
