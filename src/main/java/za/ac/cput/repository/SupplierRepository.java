package za.ac.cput.repository;


import za.ac.cput.domain.Supplier;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepository {
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
    //creating a new supplier
    public Supplier create(Supplier supplier){
        boolean success = supplierDB.add(supplier);
        if(!success){
            return null;
        }
        return supplier;
    }
    //retrieving a supplier
    public Supplier read(String supplierId) {
        // Lambda expressions Java 8
        Supplier supplier = supplierDB.stream()
                .filter(j -> j.getSupplierId().equals(supplierId))
                .findAny()
                .orElse(null);
        return supplier;
    }
    public Supplier update(Supplier supplier){
        Supplier oldSupplier = read(supplier.getSupplierId());
        if(oldSupplier != null){
            supplierDB.remove(oldSupplier);
            supplierDB.add(supplier);
            return supplier;
        }
        return null;
    }
    public boolean delete(String supplierId) {
        Supplier supplierToDelete = read(supplierId);
        if (supplierToDelete == null){
            return false;
        }
        supplierDB.remove(supplierToDelete);
        return true;
    }
    public Set<Supplier> getAll() {
        return supplierDB;
    }

}
