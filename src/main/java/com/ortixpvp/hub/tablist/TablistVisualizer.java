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
        return CC.translate("&5&lOrtixPvP Network");
    }

    @Override
    public String getFooter(Player player) {
        return CC.translate("&7You're playing on &5ortixpvp.com&7.");
    }

    @Override
    public List<TabEntry> getLines(Player player) {
        List<TabEntry> lines = new ArrayList<>();

        lines.add(new TabEntry(0, 4, "&5&lWelcome " + player.getName()).setPing(-1));
        lines.add(new TabEntry(0, 6, " &7Rank: &5" + "null").setPing(-1));
        lines.add(new TabEntry(0, 8, " &7Staff Online: &5" + "1").setPing(-1));
        lines.add(new TabEntry(0, 10, " &7Players Online: &5" + Bukkit.getOnlinePlayers().size()).setPing(-1));

        lines.add(new TabEntry(1, 4, "&5&lServers").setPing(-1));

        lines.add(new TabEntry(1, 6, " &5SoupPvP &7(0/100)").setPing(-1));
        lines.add(new TabEntry(1, 7, "  &cOffline").setPing(-1));

        lines.add(new TabEntry(1, 9, " &5Practice &7(0/100)").setPing(-1));
        lines.add(new TabEntry(1, 10, "  &cOffline").setPing(-1));

        lines.add(new TabEntry(1, 12, " &5HCF &7(0/100)").setPing(-1));
        lines.add(new TabEntry(1, 13, "  &cOffline").setPing(-1));

        lines.add(new TabEntry(2, 4, "&5&lInformation").setPing(-1));
        lines.add(new TabEntry(2, 6, " &7Store").setPing(-1));
        lines.add(new TabEntry(2, 7, "  &5store.ortixpvp.com").setPing(-1));
        lines.add(new TabEntry(2, 9, " &7Discord").setPing(-1));
        lines.add(new TabEntry(2, 10, " &5discord.ortixpvp.com").setPing(-1));
        lines.add(new TabEntry(2, 12, "&7Twitter").setPing(-1));
        lines.add(new TabEntry(2, 13, " &5twitter.ortixpvp.com").setPing(-1));

        lines.add(new TabEntry(3, 4, "&c&lWarning!").setPing(-1));
        lines.add(new TabEntry(3, 5, " &7This server is in beta").setPing(-1));
        lines.add(new TabEntry(3, 6, " &7and may contain bugs.").setPing(-1));
        lines.add(new TabEntry(3, 7, " &7Please report any bugs").setPing(-1));
        lines.add(new TabEntry(3, 8, " &7to our staff team.").setPing(-1));

        return lines;
    }
}
