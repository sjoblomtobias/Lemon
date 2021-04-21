package com.murengezi.lemon.Event;

import com.murengezi.lemon.Lemon;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.List;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 16:56
 */
public class Ping implements Listener {

	@EventHandler
	public void call(ServerListPingEvent event) {
		List<String> lines = (List<String>) Lemon.getInstance().getConfig().getList("Motd");
		assert lines.size() == 2;
		event.motd(Component.text(lines.get(0) + "\n" + lines.get(1)));
	}

}
