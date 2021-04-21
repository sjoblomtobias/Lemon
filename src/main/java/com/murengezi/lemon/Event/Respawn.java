package com.murengezi.lemon.Event;

import com.murengezi.lemon.Lemon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 20:49
 */
public class Respawn implements Listener {

	@EventHandler
	public void call(PlayerRespawnEvent event) {
		if (Lemon.getBanManager().getBans().containsKey(event.getPlayer().getUniqueId()) && Lemon.getBanManager().deltaTime(event.getPlayer().getUniqueId()) < 0l) {
			Lemon.getBanManager().remove(event.getPlayer().getUniqueId());
		}
	}

}
