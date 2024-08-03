package com.ortixpvp.hub;

import com.ortixpvp.hub.api.assemble.Assemble;
import com.ortixpvp.hub.api.assemble.AssembleStyle;
import com.ortixpvp.hub.api.command.CommandFramework;
import com.ortixpvp.hub.api.frozedtab.FrozedTablist;
import com.ortixpvp.hub.api.menu.MenuListener;
import com.ortixpvp.hub.command.ServerSelectorCommand;
import com.ortixpvp.hub.listener.EnderButtListener;
import com.ortixpvp.hub.listener.HotbarListener;
import com.ortixpvp.hub.listener.PlayerListener;
import com.ortixpvp.hub.listener.WorldListener;
import com.ortixpvp.hub.scoreboard.ScoreboardVisualizer;
import com.ortixpvp.hub.tablist.TablistVisualizer;
import com.ortixpvp.hub.util.CC;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

@Getter
public class OrtixHub extends JavaPlugin {

    @Getter
    private static OrtixHub instance;

    private CommandFramework commandFramework;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        commandFramework = new CommandFramework();

        Arrays.asList(
                new ServerSelectorCommand()
        ).forEach(command -> commandFramework.registerCommands(command));

        Arrays.asList(
                new MenuListener(),
                new WorldListener(),
                new HotbarListener(),
                new PlayerListener(),
                new EnderButtListener()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));

        Assemble assemble = new Assemble(this, new ScoreboardVisualizer());
        assemble.setAssembleStyle(AssembleStyle.MODERN);
        assemble.setTicks(2);

        new FrozedTablist(this, new TablistVisualizer(), 0, 20);

        List<String> enableMessage = Arrays.asList(
                " ",
                "&c&lOrtix HubCore",
                " &7Version: &c" + getDescription().getVersion(),
                " &7Author: &c" + getDescription().getAuthors().get(0),
                " "
        );
        enableMessage.forEach(message -> Bukkit.getConsoleSender().sendMessage(CC.translate(message)));
    }

    @Override
    public void onDisable() {
        List<String> disableMessage = Arrays.asList(
                " ",
                "&c&lDisabled OrtixHub!",
                " "
        );
        disableMessage.forEach(message -> Bukkit.getConsoleSender().sendMessage(CC.translate(message)));
    }
}
