package za.ac.cput.repository;

import za.ac.cput.domain.PaintInventory;
import java.util.HashSet;
import java.util.Set;

public class PaintInventoryRepository implements IPaintInventoryRepository {
    private static PaintInventoryRepository paintInventoryRepository = null;
    private Set<PaintInventory> paintInventoryDB = null;
    private PaintInventoryRepository(){
        paintInventoryDB = new HashSet<PaintInventory>();
    }
    public static PaintInventoryRepository getPaintInventoryRepository(){
        if(paintInventoryRepository==null){
            paintInventoryRepository= new PaintInventoryRepository();
        }
        return paintInventoryRepository;
    }
    @Override
    public PaintInventory create(PaintInventory paintInventory) {
        boolean success = paintInventoryDB.add(paintInventory);
        if (!success) {
            return null;
        }
        return paintInventory;
    }

    @Override
    public PaintInventory read(String paintInventory) {
        // Lambda expressions Java 8
        PaintInventory paintInventory1 = paintInventoryDB.stream()
                .filter(j -> j.getColorId().equals(paintInventory))
                .findAny()
                .orElse(null);
        return paintInventory1;
    }

    @Override
    public PaintInventory update(PaintInventory paintInventory) {
        PaintInventory paintInventory1 = read(paintInventory.getColorId());
        if(paintInventory1 != null){
            paintInventoryDB.remove(paintInventory1);
            paintInventoryDB.add(paintInventory);
            return paintInventory;
        }
        return paintInventory;
    }

    @Override
    public boolean delete(String paintInventory) {
        PaintInventory paintToDelete = read(paintInventory);
        if (paintToDelete == null){
            return false;
        }
        paintInventoryDB.remove(paintToDelete);
        return true;
    }
    @Override
    public Set<PaintInventory> getAll() {
        return paintInventoryDB;
    }
}
