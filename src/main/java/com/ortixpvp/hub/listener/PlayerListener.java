package com.ortixpvp.hub.listener;

import com.ortixpvp.hub.hotbar.Hotbar;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 07:41
 */
public class PlayerListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.getInventory().setHeldItemSlot(4);
        Hotbar.applyHotbarItems(player);
        player.updateInventory();

        event.setJoinMessage(null);
    }
}
