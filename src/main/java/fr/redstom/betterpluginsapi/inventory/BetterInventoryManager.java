package fr.redstom.betterpluginsapi.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BetterInventoryManager implements Listener {

    /**
     * The event to detect if an inventory is clicked
     * @param event The event of the click
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        getInventories().forEach(inventory -> {
            if(event.getClickedInventory() == null || event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) return;
            if(event.getClickedInventory().getName().equalsIgnoreCase(inventory.getInventory().getName())){
                inventory.onClick(event);
                event.setCancelled(true);
            }
        });

    }

    private static List<BetterInventory> inventoryList = new ArrayList<>();

    /**
     * The method to add an inventory to the list
     * @param inventory The inventory to add
     */
    public static void addInventory(BetterInventory inventory){
        inventoryList.add(inventory);
    }

    /**
     * The method to remove an inventory to the list
     * @param inventory The inventory to remove
     */
    public static void removeInventory(BetterInventory inventory){
        inventoryList.remove(inventory);
    }

    /**
     * The method to get the list
     * @return All the inventories
     */
    public static Collection<BetterInventory> getInventories(){
        return inventoryList;
    }

}
