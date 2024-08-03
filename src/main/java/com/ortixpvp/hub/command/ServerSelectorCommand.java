package com.ortixpvp.hub.command;

import com.ortixpvp.hub.api.command.BaseCommand;
import com.ortixpvp.hub.api.command.CommandArgs;
import com.ortixpvp.hub.api.command.annotation.Command;
import com.ortixpvp.hub.menus.ServerSelectorMenu;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project OrtixHub
 * @date 03/08/2024 - 07:48
 */
public class ServerSelectorCommand extends BaseCommand {
    @Override
    @Command(name = "serverselector")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        new ServerSelectorMenu().openMenu(player);
    }
}
