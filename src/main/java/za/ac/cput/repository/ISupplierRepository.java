package za.ac.cput.repository;


import za.ac.cput.domain.Supplier;

import java.util.Set;

public interface ISupplierRepository {
    public Set<Supplier> getAll();
}
