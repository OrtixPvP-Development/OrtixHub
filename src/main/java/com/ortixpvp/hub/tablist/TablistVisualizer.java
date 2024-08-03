package com.ortixpvp.hub.tablist;

import com.ortixpvp.hub.OrtixHub;
import com.ortixpvp.hub.api.frozedtab.adapter.TabAdapter;
import com.ortixpvp.hub.api.frozedtab.entry.TabEntry;
import com.ortixpvp.hub.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 16:50
 */
public class TablistVisualizer implements TabAdapter {
    @Override
    public String getHeader(Player player) {
        return CC.translate("&c&lTulip Network");
    }

    @Override
    public String getFooter(Player player) {
        return CC.translate("&7You're playing on &ctulip.club&7.");
    }

    @Override
    public List<TabEntry> getLines(Player player) {
        List<TabEntry> lines = new ArrayList<>();

        lines.add(new TabEntry(0, 0, "&c&lWelcome").setPing(-1));
        lines.add(new TabEntry(0, 2, " &7" + player.getName()).setPing(-1));
        lines.add(new TabEntry(0, 4, " &7Rank: &c" + "null").setPing(-1));
        lines.add(new TabEntry(0, 6, " &7Staff Online: &c" + "1").setPing(-1));
        lines.add(new TabEntry(0, 8, " &7Players Online: &c" + Bukkit.getOnlinePlayers().size()).setPing(-1));

        lines.add(new TabEntry(1, 4, "&c&lServers").setPing(-1));
        lines.add(new TabEntry(1, 6, " &7SoupPvP").setPing(-1));
        lines.add(new TabEntry(1, 8, " &7Practice").setPing(-1));
        lines.add(new TabEntry(1, 10, " &7KitMap").setPing(-1));

        lines.add(new TabEntry(3, 4, "&c&lInformation").setPing(-1));
        lines.add(new TabEntry(3, 6, " &7Store").setPing(-1));
        lines.add(new TabEntry(3, 7, " &cstore.tulip.club").setPing(-1));
        lines.add(new TabEntry(3, 9, " &7Discord").setPing(-1));
        lines.add(new TabEntry(3, 10, " &cdiscord.tulip.club").setPing(-1));
        lines.add(new TabEntry(3, 12, " &7Twitter").setPing(-1));
        lines.add(new TabEntry(3, 13, " &ctwitter.tulip.club").setPing(-1));

        return lines;
    }
}
