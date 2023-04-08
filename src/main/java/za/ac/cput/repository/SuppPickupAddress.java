package za.ac.cput.repository;
import java.util.HashSet;
import java.util.Set;

public class SuppPickupAddress {
    private static SuppPickupAddress suppPickupAddress = null;
    private Set<SuppPickupAddress> SuppPickupAddressDB = null;
    private SuppPickupAddress(){
        SuppPickupAddressDB = new HashSet<SuppPickupAddress>();
    }
    public static SuppPickupAddress getSuppPickupAddressRepository(){
        if(suppPickupAddress ==null){
            suppPickupAddress= new SuppPickupAddress();
        }
        return null;
    }
    //creating a new supplier
    public SuppPickupAddress create(SuppPickupAddress suppPickupAddress){
        boolean success = SuppPickupAddressDB.add(suppPickupAddress);
        if(!success){
            return null;
        }
        return suppPickupAddress;
    }
    //retrieving a supplier
    public SuppPickupAddress read(SuppPickupAddress suppPickupAddress) {
        // Lambda expressions Java 8
        SuppPickupAddress pickupAddressRepository = SuppPickupAddressDB.stream()
                .filter(j -> j.SuppPickupAddressDB.equals(suppPickupAddress))
                .findAny()
                .orElse(null);
        return suppPickupAddress;
    }
    public SuppPickupAddress update(SuppPickupAddress suppPickupAddress){
        SuppPickupAddress oldAddress = read(suppPickupAddress);
        if(oldAddress != null){
            SuppPickupAddressDB.remove(oldAddress);
            SuppPickupAddressDB.add(suppPickupAddress);
            return suppPickupAddress;
        }
        return null;
    }
    public boolean delete(SuppPickupAddress suppPickupAddress) {
        SuppPickupAddress pickupAddressToDelete = read(suppPickupAddress);
        if (pickupAddressToDelete == null){
            return false;
        }
        SuppPickupAddressDB.remove(pickupAddressToDelete);
        return true;
    }
    public Set<SuppPickupAddress> getAll() {
        return null;
    }
}
