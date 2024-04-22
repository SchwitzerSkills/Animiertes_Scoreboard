package de.test.spigot.testscoreboard.listeners;

import de.test.spigot.testscoreboard.TestScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        TestScoreboard.getInstance().getScoreboardUtil().setScoreboard(p);
    }
}
