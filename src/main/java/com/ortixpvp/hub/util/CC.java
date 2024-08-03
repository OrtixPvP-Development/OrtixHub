package com.ortixpvp.hub.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 07:16
 */
@UtilityClass
public class CC {

    public String MENU_BAR = translate("&7&m------------------------");

    /**
     * Translate a string with the '&' character
     *
     * @param string the string to translate
     * @return the translated string
     */
    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
