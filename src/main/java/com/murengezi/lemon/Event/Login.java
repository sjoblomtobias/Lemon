package com.murengezi.lemon.Event;

import com.murengezi.lemon.Lemon;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 17:50
 */
public class Login implements Listener {

	@EventHandler
	public void call(AsyncPlayerPreLoginEvent event) {
		if (Lemon.getBanManager().getBans().containsKey(event.getUniqueId()) && Lemon.getBanManager().deltaTime(event.getUniqueId()) > 0l) {
			event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, Component.text(Lemon.getInstance().getConfig().getString("Ban-Message").replace("{time}", getTimeFromMillis(Lemon.getBanManager().deltaTime(event.getUniqueId())))));
		}

		if (Lemon.getInstance().getConfig().getConfigurationSection("Name-Changer").getKeys(false).contains(event.getName())) {
			event.getPlayerProfile().setName(Lemon.getInstance().getConfig().getString("Name-Changer." + event.getName()));
		}
	}

	public String getTimeFromMillis(long time) {
		long second = (time / 1000) % 60;
		long minute = (time / (1000 * 60)) % 60;
		long hour = (time / (1000 * 60 * 60)) % 24;
		return hour + "h " + minute + "m " + second + "s";
	}

}
