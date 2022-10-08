package io.github.robaertschi;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.logging.Level;

import static java.lang.System.out;

public class JobsHandlerListener implements Listener {

    public static Jobs[] usedJobs = new Jobs[5];

    @EventHandler
    public void joinCreateUser(PlayerJoinEvent e)
    {
        UserDataHandler user = new UserDataHandler(e.getPlayer().getUniqueId());
        var random = new Random();

        job:
        while (true) {
            int jobInt = random.nextInt(5);
            Jobs job = Jobs.from(jobInt);
            int i = 0;

            // TODO: Add Job to Array or retry to get a Job.

            usedJobs[i] = job;

            user.createUser(e.getPlayer(), job);
            break job;
        }

        for (Jobs job:
             usedJobs) {
            out.println(job);
        }

    }

}
