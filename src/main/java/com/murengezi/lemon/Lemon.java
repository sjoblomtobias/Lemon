package com.murengezi.lemon;

import com.murengezi.lemon.Ban.BanManager;
import com.murengezi.lemon.Command.CommandManager;
import com.murengezi.lemon.Event.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Lemon extends JavaPlugin {

	private static Lemon instance;
	private static CommandManager commandManager;
	private static BanManager banManager;

	public static final String PREFIX = "§f[§eLemon§f] §r";

	@Override
	public void onEnable() {
		instance = this;
		commandManager = new CommandManager();
		banManager = new BanManager();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Join(), instance);
		pm.registerEvents(new Quit(), instance);
		pm.registerEvents(new Message(), instance);
		pm.registerEvents(new Ping(), instance);
		pm.registerEvents(new Login(), instance);
		pm.registerEvents(new Death(), instance);
		pm.registerEvents(new Respawn(), instance);
		File configFile = new File(this.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			saveDefaultConfig();
		}
	}

	@Override
	public void onDisable() {
		configSaveAll();
		instance = null;
	}

	public void configSaveAll() {
		reloadConfig();
		getConfig().set("Bans", null);
		getBanManager().getBans().forEach((uuid, time) -> Lemon.getInstance().getConfig().set("Bans." + uuid.toString(), time));
		saveConfig();
	}

	public static Lemon getInstance() {
		return instance;
	}

	public static CommandManager getCommandManager() {
		return commandManager;
	}

	public static BanManager getBanManager() {
		return banManager;
	}
}
