package io.github.robaertschi;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PluginConfig {

    private final File configFile;
    private final FileConfiguration pluginConfig;

    public PluginConfig() {
        this.configFile = new File(FairJobsPlugin.getInstance().getDataFolder(), "config.yml");

        this.pluginConfig = YamlConfiguration.loadConfiguration(configFile);


    }

    public void createConfig() {
        if (!(configFile.exists())) {

            try {
                YamlConfiguration pluginConfig = YamlConfiguration.loadConfiguration(configFile);

                pluginConfig.set("Plugin.Data.Jobs", new Jobs[5]);

                pluginConfig.save(configFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public FileConfiguration getPluginConfig() {
        return pluginConfig;
    }

    public void savePluginFile() {
        try {
            getPluginConfig().save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
