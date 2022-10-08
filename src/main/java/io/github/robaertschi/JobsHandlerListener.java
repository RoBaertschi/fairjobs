package io.github.robaertschi;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class JobsHandlerListener implements Listener {

    private static Jobs[] usedJobs = new Jobs[5];

    @EventHandler
    public void joinCreateUser(PlayerJoinEvent e)
    {
        UserDataHandler user = new UserDataHandler(e.getPlayer().getUniqueId());
        var random = new Random();

        job:
        while (true) {
            int jobInt = random.nextInt(5);
            Jobs job = Jobs.from(jobInt);

            for (Jobs eachJob:
                 usedJobs) {
                if (eachJob == job) {
                    continue job;
                }
            }

            user.createUser(e.getPlayer(), job);
            break job;
        }

        System.out.println("Hi");

    }

}
