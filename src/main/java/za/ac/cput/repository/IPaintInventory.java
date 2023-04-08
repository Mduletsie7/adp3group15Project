package za.ac.cput.repository;

import za.ac.cput.domain.PaintInventory;

import java.util.Set;

public interface IPaintInventory {
    public Set<PaintInventory> getAll();
}
