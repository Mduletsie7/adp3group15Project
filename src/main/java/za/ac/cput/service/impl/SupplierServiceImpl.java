package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.ISupplierRepository;
import za.ac.cput.service.SupplierService;

import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Supplier Service implementation in business logic
 * due date: 22/10/2023
 * */
@Service
public class SupplierServiceImpl implements SupplierService {
    private ISupplierRepository repository;

    @Autowired
    private SupplierServiceImpl(ISupplierRepository repository) {
        this.repository = repository;
    }
    @Override
    public Supplier create(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public Supplier read(String supplierId) {
        return this.repository.findById(supplierId).orElse(null);
    }

    @Override
    public Supplier update(Supplier supplier) {
        if(this.repository.existsById(supplier.getSupplierId())){
            return this.repository.save(supplier);
        }
        return null;
    }

    @Override
    public boolean delete(String supplierId) {
        if(this.repository.existsById(supplierId)){
            this.repository.deleteById(supplierId);
        }
        return true;
    }

    @Override
    public List<Supplier> getAll() {
        return this.repository.getAll();
    }
}
