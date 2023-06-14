package za.ac.cput.repository.impl;


import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.ISupplierRepository;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepository implements ISupplierRepository {
    public static SupplierRepository supplierRepository = null;
    private Set<Supplier> supplierDB = null;
    private SupplierRepository(){
        supplierDB = new HashSet<Supplier>();
    }
    public static SupplierRepository getSupplierRepository(){
        if(supplierRepository==null){
            supplierRepository= new SupplierRepository();
        }
        return supplierRepository;
    }
    @Override
    public Supplier create(Supplier supplier){
        boolean success = supplierDB.add(supplier);
        if(!success){
            return null;
        }
        return supplier;
    }
    @Override
    public Supplier read(String supplierId) {
        // Lambda expressions Java 8
        Supplier supplier = supplierDB.stream()
                .filter(j -> j.getSupplierId().equals(supplierId))
                .findAny()
                .orElse(null);
        return supplier;
    }
    @Override
    public Supplier update(Supplier supplier){
        Supplier oldSupplier = read(supplier.getSupplierId());
        if(oldSupplier != null){
            supplierDB.remove(oldSupplier);
            supplierDB.add(supplier);
            return supplier;
        }
        return null;
    }
    @Override
    public boolean delete(String supplierId) {
        Supplier supplierToDelete = read(supplierId);
        if (supplierToDelete == null){
            return false;
        }
        supplierDB.remove(supplierToDelete);
        return true;
    }
    @Override
    public Set<Supplier> getAll() {
        return supplierDB;
    }

}
