package io.github.robaertschi;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FairJobsPlugin extends JavaPlugin implements Listener {

    private static FairJobsPlugin instance;

    public static PluginConfig pluginConfig;


    public static FairJobsPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JobsHandlerListener(), this);
        FairJobsPlugin.instance = this;

        pluginConfig = new PluginConfig();

        try {
            JobsHandlerListener.usedJobs = (Jobs[]) pluginConfig.getPluginConfig().get("Plugin.Data.Jobs");
        } catch (ClassCastException e) {
            JobsHandlerListener.usedJobs = new Jobs[5];
        }
        if (JobsHandlerListener.usedJobs == null) {
            JobsHandlerListener.usedJobs = new Jobs[5];
        }

    }

    @Override
    public void onDisable() {
        pluginConfig.getPluginConfig().set("Plugin.Data.Jobs", JobsHandlerListener.usedJobs);

        pluginConfig.savePluginFile();
    }


}
