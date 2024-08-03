package com.ortixpvp.hub.listener;

import com.ortixpvp.hub.hotbar.Hotbar;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 07:43
 */
public class HotbarListener implements Listener {

    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() == null) {
            return;
        }

        Hotbar hotbarItem = Hotbar.getItem(event.getItem());
        if (hotbarItem == null) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (hotbarItem.getCommand() != null) {
            player.performCommand(hotbarItem.getCommand());
            Bukkit.getConsoleSender().sendMessage("Performing command: " + hotbarItem.getCommand());
        }

        event.setCancelled(true);
    }
}
