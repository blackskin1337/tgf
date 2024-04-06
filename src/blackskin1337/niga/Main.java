package blackskin1337.niga;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin implements CommandExecutor {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);

        this.getCommand("feka").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("feka")) {
            if (!sender.hasPermission("feka.borszin")) {
                sender.sendMessage("Nincs jogosultságod ehhez a parancshoz.");
                return true;
            }

            if (!config.contains("message")) {
                sender.sendMessage("Nem irtal bele semmit okostojas.");
                return true;
            }

            sender.sendMessage(config.getString("message"));
            return true;
        }
        return false;
    }
}
