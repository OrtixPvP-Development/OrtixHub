package com.ortixpvp.hub;

import com.ortixpvp.hub.api.command.CommandFramework;
import com.ortixpvp.hub.api.menu.MenuListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

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

        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
