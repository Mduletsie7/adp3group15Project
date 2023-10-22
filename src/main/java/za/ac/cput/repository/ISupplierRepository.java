package za.ac.cput.repository;


import za.ac.cput.domain.SuppPickupAddress;
import za.ac.cput.domain.Supplier;

import java.util.Set;

public interface ISupplierRepository extends IRepository<Supplier, String> {
    public Set<Supplier> getAll();
}
