package za.ac.cput.factory;

import za.ac.cput.domain.PaintInventory;
import za.ac.cput.util.Helper;

public class PaintInventoryFactory {
    public static PaintInventory createInventory(String colorId, String transHistory, String amtAvailable){
        if(Helper.isNullOrEmpty(transHistory) || Helper.isNullOrEmpty(amtAvailable)){
        }

        PaintInventory paintInventory = new PaintInventory.Builder()
                .setColorId(colorId)
                .setTransHistory(transHistory)
                .setAmtAvailable(amtAvailable)
                .build();

                return paintInventory;

    }
}
