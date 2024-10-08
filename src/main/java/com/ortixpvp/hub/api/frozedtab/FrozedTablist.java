package com.ortixpvp.hub.api.frozedtab;

import com.ortixpvp.hub.api.frozedtab.adapter.TabAdapter;
import com.ortixpvp.hub.api.frozedtab.layout.TabLayout_v1_7;
import com.ortixpvp.hub.api.frozedtab.layout.TabLayout_v1_8;
import com.ortixpvp.hub.api.frozedtab.listener.TabListener;
import com.ortixpvp.hub.api.frozedtab.packet.TabPacket_v1_7;
import com.ortixpvp.hub.api.frozedtab.packet.TabPacket_v1_8;
import com.ortixpvp.hub.api.frozedtab.runnable.TabRunnable_v1_7;
import com.ortixpvp.hub.api.frozedtab.runnable.TabRunnable_v1_8;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class FrozedTablist {

    /*
    Forked from Hatsur API
    Links:
    -> https://github.com/norxir/seventab
    -> https://github.com/norxir/eighttab
     */

    @Getter private static FrozedTablist instance;

    private final TabAdapter adapter;

    private Version version;

    public FrozedTablist(JavaPlugin plugin, TabAdapter adapter, int delay1, int delay2) {
        instance = this;
        this.adapter = adapter;

        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);
        try {
            this.version = Version.valueOf(version);
            plugin.getLogger().info("[Tab] Using " + this.version.name() + " version.");
        } catch (final Exception e) {
            e.printStackTrace();
            return;
        }

        handlerPacket(plugin);

        Bukkit.getServer().getPluginManager().registerEvents(new TabListener(this), plugin);
        switch (this.version) {
            case v1_7_R4:
                Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new TabRunnable_v1_7(adapter), delay1, delay2); //TODO: async to run 1 millis
                break;
            case v1_8_R3:
                Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new TabRunnable_v1_8(adapter), delay1, delay2); //TODO: async to run 1 millis
                break;
        }
    }

    private void handlerPacket(JavaPlugin plugin) {
        switch (this.version) {
            case v1_7_R4:
                new TabPacket_v1_7(plugin);
                break;
            case v1_8_R3:
                new TabPacket_v1_8(plugin);
                break;
        }
    }

    public void onDisable() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            removePlayer(player);
        }
    }

    public void removePlayer(Player player) {
        boolean continueAt = false;
        switch (this.version) {
            case v1_7_R4:
                if (TabLayout_v1_7.getLayoutMapping().containsKey(player.getUniqueId())) {
                    continueAt = true;
                }

                if (continueAt) {
                    TabLayout_v1_7.getLayoutMapping().remove(player.getUniqueId());
                }
                break;
            case v1_8_R3:
                if (TabLayout_v1_8.getLayoutMapping().containsKey(player.getUniqueId())) {
                    continueAt = true;
                }

                if (continueAt) {
                    TabLayout_v1_8.getLayoutMapping().remove(player.getUniqueId());
                }
                break;
        }
    }

    public enum Version {
        v1_7_R4,
        v1_8_R3
    }
}
