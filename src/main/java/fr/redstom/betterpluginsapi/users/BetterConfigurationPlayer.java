package fr.redstom.betterpluginsapi.users;

import fr.redstom.betterpluginsapi.plugin.BetterPlugin;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class BetterConfigurationPlayer {

    private OfflinePlayer player;
    private YamlConfiguration configuration;

    public BetterConfigurationPlayer(BetterPlugin plugin, OfflinePlayer player) {
        this.player = player;
        this.configuration = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "users/" + player.getUniqueId() + ".yml"));
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public YamlConfiguration getConfig() {
        return configuration;
    }

    public void set(String path, Object value){
        configuration.set(path, value);
    }

    public boolean is(String path){
        return configuration.get(path) != null;
    }

    public<T> T getOrDefault(String path, T default_){
        return is(path) ? (T) configuration.get(path) : default_;
    }

    public Object get(String path){
        return configuration.get(path);
    }

}
