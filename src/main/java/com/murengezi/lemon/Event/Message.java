package com.murengezi.lemon.Event;

import com.murengezi.lemon.Lemon;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 16:49
 */
public class Message implements Listener {

	@EventHandler
	public void call(AsyncChatEvent event) {
		event.setCancelled(true);
		Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(format(event.getPlayer(), ((TextComponent)event.message()).content())));
	}

	public String format(Player player, String message) {
		return Lemon.getInstance().getConfig().getString("Message-Format").replace("{player}", player.getName()).replace("{message}", message);
	}

}
