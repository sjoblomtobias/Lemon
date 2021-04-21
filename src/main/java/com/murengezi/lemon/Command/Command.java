package com.murengezi.lemon.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 17:16
 */
public abstract class Command {

	private String name = getClass().getAnnotation(CommandInfo.class).name();

	public abstract void execute(CommandSender sender, String[] args);

	public String getName() {
		return name;
	}
}
