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
        return CC.translate("&c&lTulip Network");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();

        lines.add(CC.translate("&r                             "));
        lines.add(CC.translate("&cWelcome to Tulip Network"));
        lines.add(CC.translate("&cRight Click the compass"));
        lines.add(CC.translate("&cto select a server!"));
        lines.add(CC.translate(" "));
        lines.add(CC.translate("&fOnline: &c" + Bukkit.getOnlinePlayers().size()));
        lines.add(CC.translate("&fSeason: &c#1"));
        lines.add(CC.translate(" "));
        lines.add(CC.translate("&ctulip.club"));
        lines.add(CC.translate("&r                             "));

        return lines;
    }
}
