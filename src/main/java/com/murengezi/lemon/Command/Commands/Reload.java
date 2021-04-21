package com.murengezi.lemon.Command.Commands;

import com.murengezi.lemon.Command.Command;
import com.murengezi.lemon.Command.CommandInfo;
import com.murengezi.lemon.Lemon;
import org.bukkit.command.CommandSender;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 17:18
 */
@CommandInfo(name = "Reload")
public class Reload extends Command {

	@Override
	public void execute(CommandSender sender, String[] args) {
		Lemon.getInstance().reloadConfig();
		sender.sendMessage(Lemon.PREFIX + "Config reloaded.");
	}

}
