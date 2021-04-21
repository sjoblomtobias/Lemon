package com.murengezi.lemon.Event;

import com.murengezi.lemon.Lemon;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import javax.management.loading.MLetMBean;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 17:56
 */
public class Death implements Listener {

	@EventHandler
	public void call(PlayerDeathEvent event) {
		Player player = event.getEntity();
		new BukkitRunnable() {
			@Override
			public void run() {
				if (!Lemon.getBanManager().getBans().containsKey(player.getUniqueId())) {
					player.kick(Component.text("Hahah du dog!"));
					Lemon.getBanManager().add(player.getUniqueId());
				}
			}
		}.runTaskLater(Lemon.getInstance(), 10l);
	}

}
