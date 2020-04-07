package fr.redstom.betterpluginsapi.plugin;

import fr.redstom.betterpluginsapi.commands.BetterCommandExecutor;
import fr.redstom.betterpluginsapi.events.BetterEventExecutor;
import fr.redstom.betterpluginsapi.inventory.BetterInventoryManager;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public abstract class BetterPlugin extends JavaPlugin {


    @Override
    public void onLoad() {
        onPluginLoading();
    }

    @Override
    public void onEnable() {
        registerEvent(new BetterInventoryManager());
        registerData();
        registerCommands();
        registerEvents();
        onPluginEnabling();
    }

    @Override
    public void onDisable() {
        onPluginDisabling();
    }

    /**
     * Executes when the plugin is loading
     */
    public abstract void onPluginLoading();

    /**
     * Executes when the plugin is enabling
     */
    public abstract void onPluginEnabling();

    /**
     * Executes when the plugin is disabling
     */
    public abstract void onPluginDisabling();

    /**
     * Method to register the commands. Executes when the plugin is enabling.
     */
    public abstract void registerCommands();

    /**
     * Method to register the events. Executes when the plugin is enabling.
     */
    public abstract void registerEvents();

    /**
     * Method to register the data. Executes when the plugin is enabling.
     */
    public abstract void registerData();

    /**
     * Method to register a single command
     * @param name Name of the command. It needs to be specified in the plugin.yml.
     * @param executor Executor of the command.
     */
    protected void registerCommand(String name, BetterCommandExecutor executor){
        getCommand(name).setExecutor(executor);
    }

    /**
     * Method to register a single event
     * @param eventType Type of the event. Needs to extends {@link Event}
     * @param executor Executor of the event.
     * @param <T> Type of the event. Needs to extends {@link Event}
     */
    protected<T extends Event> void registerEvent(Class<T> eventType, BetterEventExecutor<T> executor){
        getServer().getPluginManager().registerEvent(eventType, executor, EventPriority.LOWEST, executor, this);
    }

    /**
     * Method to register a listener
     * @param listener Listener to register
     */
    protected void registerEvent(Listener listener){
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
