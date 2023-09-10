package za.ac.cput.repository;

import za.ac.cput.domain.PaintInventory;

import java.util.Set;

public interface IPaintInventoryRepository extends IRepository<PaintInventory, String> {
    //creating a new supplier
    public Set<PaintInventory> getAll();
}
