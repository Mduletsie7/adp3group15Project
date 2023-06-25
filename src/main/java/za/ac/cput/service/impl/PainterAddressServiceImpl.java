package za.ac.cput.service.impl;

import za.ac.cput.domain.PainterAddress;
import za.ac.cput.repository.impl.PainterAddressRepository;
import za.ac.cput.service.PainterAddressService;

import java.util.Set;

public class PainterAddressServiceImpl implements PainterAddressService {

    private static PainterAddressServiceImpl service = null;

    private static PainterAddressRepository repository = null;

    private PainterAddressServiceImpl() { repository = PainterAddressRepository.getRepository(); }

    public static  PainterAddressServiceImpl getService() {
        if (service == null) {
            service = new PainterAddressServiceImpl();
        }
        return service;
    }

    @Override
    public PainterAddress create(PainterAddress painterAddress) {
        PainterAddress created = repository.create(painterAddress);
        return created;
    }

    public PainterAddress read(String painterAddressId) {
        PainterAddress readPainterAddress = repository.read(painterAddressId);
        return readPainterAddress;
    }

    public PainterAddress update(PainterAddress painterAddress) {
        PainterAddress updated = repository.update(painterAddress);
        return updated;
    }

    public boolean delete(String painterAddressId) {
        boolean success = repository.delete(painterAddressId);
        return success;
    }

    public Set<PainterAddress> getAll() {return repository.getAll();}
}

