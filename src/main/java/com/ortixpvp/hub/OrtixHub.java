package com.ortixpvp.hub;

import com.ortixpvp.hub.api.command.CommandFramework;
import com.ortixpvp.hub.api.menu.MenuListener;
import com.ortixpvp.hub.command.ServerSelectorCommand;
import com.ortixpvp.hub.listener.EnderButtListener;
import com.ortixpvp.hub.listener.HotbarListener;
import com.ortixpvp.hub.listener.PlayerListener;
import com.ortixpvp.hub.listener.WorldListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

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
    }

    @Override
    public void onDisable() {
    }
}
