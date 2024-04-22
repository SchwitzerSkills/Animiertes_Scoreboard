package de.test.spigot.testscoreboard.utils;

import de.test.spigot.testscoreboard.TestScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtil {

    public void setScoreboard(Player p){
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("aaa", "bbb");

        obj.setDisplayName("§cTest Netzwerk");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        TestScoreboard.getInstance().link = sb.registerNewTeam("link");

        obj.getScore("§a").setScore(3);
        obj.getScore("§7Link§8:").setScore(2);
        TestScoreboard.getInstance().link.setSuffix("§btwitter.com");
        TestScoreboard.getInstance().link.addEntry("§b");
        obj.getScore("§b").setScore(1);
        obj.getScore("§c").setScore(0);

        p.setScoreboard(sb);
    }
}
