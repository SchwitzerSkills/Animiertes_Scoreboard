package de.test.spigot.testscoreboard;

import de.test.spigot.testscoreboard.listeners.PlayerJoinListener;
import de.test.spigot.testscoreboard.utils.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TestScoreboard extends JavaPlugin {

    public static TestScoreboard instance;

    private final ScoreboardUtil scoreboardUtil = new ScoreboardUtil();
    public Team link;
    public int scoreId = 0;

    @Override
    public void onEnable() {
        instance = this;
        updateLinks();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    public void updateLinks() {

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(all -> {
                    Scoreboard sb = all.getScoreboard();
                    Objective obj = sb.getObjective("aaa");

                    link = sb.getTeam("link");
                    switch (scoreId) {
                        case 0:
                            link.setSuffix("§bTwitter.com");
                            link.addEntry("§b");
                            obj.getScore("§b").setScore(1);
                            break;
                        case 1:
                            link.setSuffix("§cYoutube.com");
                            link.addEntry("§b");
                            obj.getScore("§b").setScore(1);
                            break;
                        case 2:
                            link.setSuffix("§9Acewolf.eu");
                            link.addEntry("§b");
                            obj.getScore("§b").setScore(1);
                            break;
                        case 3:
                            link.setSuffix("§3Facebook.com");
                            link.addEntry("§b");
                            obj.getScore("§b").setScore(1);
                            break;
                    }

                    scoreId++;

                    if (scoreId >= 3) {
                        scoreId = 0;
                    }
                });
            }
        }.runTaskTimer(TestScoreboard.getInstance(), 20, 80);
    }

    public static TestScoreboard getInstance() {
        return instance;
    }

    public ScoreboardUtil getScoreboardUtil() {
        return scoreboardUtil;
    }

    @Override
    public void onDisable() {

    }
}
