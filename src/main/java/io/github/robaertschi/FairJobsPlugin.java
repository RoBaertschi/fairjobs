package io.github.robaertschi;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FairJobsPlugin extends JavaPlugin implements Listener {

    private static FairJobsPlugin instance;


    public static FairJobsPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JobsHandlerListener(), this);
        FairJobsPlugin.instance = this;
    }

    @Override
    public void onDisable() {

    }


}
