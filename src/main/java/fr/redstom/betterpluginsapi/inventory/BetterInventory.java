package fr.redstom.betterpluginsapi.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class BetterInventory implements Listener {

    private Inventory inventory;
    private Player player;

    /**
     * The constructor of the class
     * @param inventory The inventory which is used
     * @param player The player to open the inventory
     */
    public BetterInventory(Inventory inventory, Player player){
        this.inventory = inventory;
        this.player = player;
        BetterInventoryManager.addInventory(this);
        init();
        player.openInventory(inventory);
    }

    /**
     * This method is called when the inventory is opened
     */
    protected abstract void init();

    /**
     * This method is called when the inventory is clicked
     * @param event The event of the click
     */
    public abstract void onClick(InventoryClickEvent event);

    /**
     * The method to get the current inventory
     * @return the current inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
