package za.ac.cput.repository;

import za.ac.cput.domain.PaintInventory;
import java.util.HashSet;
import java.util.Set;

public class PaintInventoryRepository extends PaintInventory implements IPaintInventory{
    private static PaintInventoryRepository paintInventoryRepository = null;
    private Set<PaintInventory> paintInventoryDB = null;
    private PaintInventoryRepository(){
        paintInventoryDB = new HashSet<PaintInventory>();
    }
    public static PaintInventoryRepository getPaintInventoryRepository(){
        if(paintInventoryRepository==null){
            paintInventoryRepository= new PaintInventoryRepository();
        }
        return null;
    }
    //creating a new supplier
    public PaintInventoryRepository create(PaintInventoryRepository paintInventory){
        boolean success = paintInventoryDB.add(paintInventory);
        if(!success){
            return null;
        }
        return paintInventory;
    }
    //retrieving a supplier
    public PaintInventory read(PaintInventoryRepository paintInventory) {
        // Lambda expressions Java 8
        PaintInventory paintInventory1 = paintInventoryDB.stream()
                .filter(j -> j.getColorId().equals(paintInventory))
                .findAny()
                .orElse(null);
        return paintInventory1;
    }
    public PaintInventoryRepository update(PaintInventoryRepository paintInventory){
        PaintInventory paintInventory1 = read(paintInventory);
        if(paintInventory1 != null){
            paintInventoryDB.remove(paintInventory1);
            paintInventoryDB.add(paintInventory);
            return paintInventoryRepository;
        }
        return null;
    }

    public boolean delete(PaintInventoryRepository paintInventory) {
        PaintInventory paintToDelete = read(paintInventory);
        if (paintToDelete == null){
            return false;
        }
        paintInventoryDB.remove(paintToDelete);
        return true;
    }
    @Override
    public Set<PaintInventory> getAll() {
        return null;
    }
}
