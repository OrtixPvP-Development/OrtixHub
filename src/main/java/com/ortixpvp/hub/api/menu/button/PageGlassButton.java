package com.ortixpvp.hub.api.menu.button;

import com.ortixpvp.hub.api.menu.Button;
import com.ortixpvp.hub.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PageGlassButton extends Button {

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.STAINED_GLASS_PANE)
                .durability(11)
                .build();
    }
}
