package com.ortixpvp.hub.scoreboard;

import com.ortixpvp.hub.api.assemble.AssembleAdapter;
import com.ortixpvp.hub.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 16:36
 */
public class ScoreboardVisualizer implements AssembleAdapter {
    @Override
    public String getTitle(Player player) {
        return CC.translate("&5&lOrtixPvP &7&l┃ &5Hub-1");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        lines.add(CC.translate("&7&m--------------------------------"));
        lines.add(CC.translate("&fOnline: &5" + Bukkit.getOnlinePlayers().size()));
        lines.add(CC.translate("&fRank: &5Default"));
        lines.add(CC.translate(" "));
        lines.add(CC.translate("&5ortixpvp.com"));
        lines.add(CC.translate("&7&m--------------------------------"));

        return lines;
    }
}
