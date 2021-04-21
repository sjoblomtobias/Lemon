package com.murengezi.lemon.Command;

import com.murengezi.lemon.Command.Commands.Reload;
import com.murengezi.lemon.Lemon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 17:18
 */
public class CommandManager implements CommandExecutor {

	private Set<com.murengezi.lemon.Command.Command> commands;

	public CommandManager() {
		Lemon.getInstance().getCommand("lemon").setExecutor(this);
		commands = new HashSet<>();
		add(new Reload());
	}

	public Set<com.murengezi.lemon.Command.Command> getCommands() {
		return commands;
	}

	public void add(com.murengezi.lemon.Command.Command command) {
		getCommands().add(command);
	}

	public com.murengezi.lemon.Command.Command get(String name) {
		return getCommands().stream().filter(command -> command.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (args.length > 0) {
			if (get(args[0]) != null) {
				get(args[0]).execute(sender, Arrays.copyOfRange(args, 1, args.length));
			} else {
				sender.sendMessage(Lemon.PREFIX + "Unknown command.");
			}
		}
		return true;
	}
}
