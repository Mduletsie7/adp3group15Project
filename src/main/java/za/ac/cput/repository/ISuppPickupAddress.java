package za.ac.cput.repository;

import za.ac.cput.domain.SuppPickupAddress;

import java.util.Set;

public interface ISuppPickupAddress extends IRepository<SuppPickupAddress, String> {
    public Set<SuppPickupAddress> getAll();
}
