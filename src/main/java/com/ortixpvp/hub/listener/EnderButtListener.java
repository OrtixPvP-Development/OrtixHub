package com.ortixpvp.hub.listener;

import com.ortixpvp.hub.hotbar.Hotbar;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 08:01
 */
public class EnderButtListener implements Listener {

    @EventHandler
    private void onPearl(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!player.getItemInHand().equals(Hotbar.ENDER_BUTT.getItem())) {
            return;
        }

        player.setVelocity(player.getLocation().getDirection().normalize().multiply(2.5F));
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);

        if (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.CREATIVE) {
            player.updateInventory();
        }
    }
}
