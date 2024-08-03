package com.ortixpvp.hub.api.command;

import com.ortixpvp.hub.OrtixHub;

/**
 * @author minnymin3
 */
public abstract class BaseCommand {

    public OrtixHub main = OrtixHub.getInstance();

    public BaseCommand() {
        main.getCommandFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
