package za.ac.cput.service;

import za.ac.cput.domain.PainterAddress;

import java.util.Set;

public interface PainterAddressService extends IService <PainterAddress, String> {
    Set<PainterAddress> getAll();
}
