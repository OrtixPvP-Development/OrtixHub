package com.ortixpvp.hub.menus;

import com.ortixpvp.hub.api.menu.Button;
import com.ortixpvp.hub.api.menu.Menu;
import com.ortixpvp.hub.util.CC;
import com.ortixpvp.hub.util.ItemBuilder;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 07:26
 */
@AllArgsConstructor
public class ServerSelectorMenu extends Menu {
    @Override
    public String getTitle(Player player) {
        return CC.translate("&5Server Selector");
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(12, new ServerSelectorButton("&5&lSoupPvP", 0, Material.MUSHROOM_SOUP,
                Arrays.asList(
                        CC.MENU_BAR,
                        "&7The original SoupPvP experience!",
                        "",
                        " &f&l* &5Abilities",
                        " &f&l* &5Leaderboards",
                        " &f&l* &5Events",
                        " &f&l* &5And more!",
                        "",
                        "&fClick to join the server!",
                        CC.MENU_BAR
                )
        ));

        buttons.put(14, new ServerSelectorButton("&5&lHardcore Factions", 0, Material.DIAMOND_SWORD,
                Arrays.asList(
                        CC.MENU_BAR,
                        "&7The original HCF experience!",
                        "",
                        " &f&l* &5Feature 1",
                        " &f&l* &5Feature 2",
                        " &f&l* &5Feature 3",
                        " &f&l* &5And more!",
                        "",
                        "&fClick to join the server!",
                        CC.MENU_BAR
                )
        ));

        addBorder(buttons, (byte) 15, 3);

        return buttons;
    }

    @Override
    public int getSize() {
        return 9 * 3;
    }

    @AllArgsConstructor
    public static class ServerSelectorButton extends Button {

        private final String name;
        private int durability;
        private final Material material;
        private List<String> lore;

        @Override
        public ItemStack getButtonItem(Player player) {
            return new ItemBuilder(material)
                    .name(name)
                    .lore(lore)
                    .durability(durability)
                    .hideMeta()
                    .build();
        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
            if (clickType != ClickType.LEFT) {
                return;
            }

            switch(material) {
                case MUSHROOM_SOUP:
                    player.performCommand("server SoupPvP");
                    break;
                case DIAMOND_SWORD:
                    player.performCommand("server HCF");
                    break;
            }
        }
    }
}
