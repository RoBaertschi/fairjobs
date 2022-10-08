package io.github.robaertschi;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class UserDataHandler {
    private UUID u;
    private File userFile;
    private FileConfiguration userConfig;

    public UserDataHandler(UUID u) {

        this.u = u;

        this.userFile = new File(FairJobsPlugin.getInstance().getDataFolder(), u + ".yml");

        this.userConfig = YamlConfiguration.loadConfiguration(userFile);
    }


    public void createUser(final Player player, final Jobs job){

        if ( !(userFile.exists()) ) {
            try {


                YamlConfiguration UserConfig = YamlConfiguration.loadConfiguration(userFile);

                UserConfig.set("FairJobs.fileVersion", "1.0");
                UserConfig.set("User.Info.PreviousName", player.getName());
                UserConfig.set("User.Info.UniqueID", player.getUniqueId().toString());
                UserConfig.set("User.Info.ipAddress", player.getAddress().getAddress().getHostAddress());
                UserConfig.set("User.Info.Job", job.toString());

                UserConfig.save(userFile);



            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }

    public FileConfiguration getUserFile(){

        return userConfig;

    }


    public void saveUserFile() {

        try {

            getUserFile().save(userFile);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
