package fr.redstom.betterpluginsapi.users;

import fr.redstom.betterpluginsapi.plugin.BetterPlugin;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BetterConfigurationPlayer {

    private OfflinePlayer player;
    private YamlConfiguration configuration;
    private File file;

    /**
     * Constructor of the player
     *
     * @param plugin Main class of the plugin
     * @param player Player
     */
    public BetterConfigurationPlayer(BetterPlugin plugin, OfflinePlayer player) {
        this.player = player;
        this.file = new File(plugin.getDataFolder(), "users/" + player.getUniqueId() + ".yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Get the player
     *
     * @return The player
     */
    public OfflinePlayer getPlayer() {
        return player;
    }

    /**
     * Get the player's configuration
     *
     * @return The player's configuration
     */
    public YamlConfiguration getConfig() {
        return configuration;
    }

    /**
     * Set a value in a specific path in the player's configuration
     *
     * @param path  Path to set the value
     * @param value Value to set
     */
    public void set(String path, Object value) {
        configuration.set(path, value);
    }

    /**
     * Know if a value in the player's configuration is null
     *
     * @param path Path to get the value
     * @return If the value is null
     */
    public boolean is(String path) {
        return configuration.get(path) != null;
    }

    /**
     * Get a value in a specific path in the player's configuration, or the default if it is null
     *
     * @param path     Path to get the value
     * @param default_ Default value if the value is null
     * @param <T>      Type of the default value
     * @return Object wich is on the path if it is not null, or the default specified if it is null
     */
    @SuppressWarnings("unchecked")
    public <T> T getOrDefault(String path, T default_) {
        return is(path) ? (T) configuration.get(path) : default_;
    }

    /**
     * Get a value in a specific path in the player's configuration
     *
     * @param path Path to get the value
     * @return Object wich is on the path
     */
    public Object get(String path) {
        return configuration.get(path);
    }

    public void update() {
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Save the file
     */
    public void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
