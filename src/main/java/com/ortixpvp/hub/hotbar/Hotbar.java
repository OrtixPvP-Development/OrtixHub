package com.ortixpvp.hub.hotbar;

import com.ortixpvp.hub.util.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 07:36
 */
@Getter
public enum Hotbar {

    SERVER_SELECTOR(Material.COMPASS, 0, "serverselector", "&cServer Selector &7(Right Click)", 3),
    ENDER_BUTT(Material.ENDER_PEARL, 0, "&cEnder Butt &7(Right Click)", 5),

    ;

    private final Material material;
    private final int durability;
    private final String command;
    private final String name;
    private final int slot;

    /**
     * Instantiates a new hotbar item
     *
     * @param material   the material of the hotbar item
     * @param durability the durability of the hotbar item
     * @param command    the command of the hotbar item
     * @param name       the name of the hotbar item
     * @param slot       the slot of the hotbar item
     */
    Hotbar(Material material, int durability, String command, String name, int slot) {
        this.material = material;
        this.durability = durability;
        this.command = command;
        this.name = name;
        this.slot = slot;
    }

    Hotbar(Material material, int durability, String name, int slot) {
        this(material, durability, null, name, slot);
    }

    /**
     * Gets the item stack of the hotbar item
     *
     * @return the item stack
     */
    public ItemStack getItem() {
        return new ItemBuilder(material)
                .name(name)
                .durability(durability)
                .build();
    }

    /**
     * Gets the hotbar item from the item stack
     *
     * @param item the item stack to get the hotbar item from
     * @return the hotbar item
     */
    public static Hotbar getItem(ItemStack item) {
        for (Hotbar hotbarItem : values()) {
            if (hotbarItem.getItem().equals(item)) {
                return hotbarItem;
            }
        }
        return null;
    }

    /**
     * Applies the hotbar items to the player's inventory
     *
     * @param player the player to apply the hotbar items to
     */
    public static void applyHotbarItems(Player player) {
        for (Hotbar hotbar : values()) {
            player.getInventory().setItem(hotbar.getSlot(), hotbar.getItem());
        }
    }
}