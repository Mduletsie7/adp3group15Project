package za.ac.cput.repository;

import za.ac.cput.domain.PainterAddress;

import java.util.Set;

public interface IPainterAddressRepository extends IRepository<PainterAddress, String>{
    public Set<PainterAddress> getAll();
}
