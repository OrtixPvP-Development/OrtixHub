package com.ortixpvp.hub.api.menu.button;

import com.ortixpvp.hub.api.menu.Button;
import com.ortixpvp.hub.api.menu.Menu;
import com.ortixpvp.hub.util.ItemBuilder;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

@AllArgsConstructor
public class BackButton extends Button {

    private Menu back;

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.ARROW)
                .name("&5&lBack")
                .durability(0)
                .lore(Arrays.asList(
                        "&5Click here to return to",
                        "&5the previous menu.")
                )
                .build();
    }

    @Override
    public void clicked(Player player, ClickType clickType) {
        Button.playNeutral(player);
        back.openMenu(player);
    }
}
