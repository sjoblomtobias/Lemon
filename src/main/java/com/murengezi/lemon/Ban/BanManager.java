package com.murengezi.lemon.Ban;

import com.murengezi.lemon.Lemon;

import javax.security.auth.login.Configuration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Tobias Sjöblom
 * Created on 2021-04-20 at 18:03
 */
public class BanManager {

	private Map<UUID, Long> bans;

	public BanManager() {
		bans = new HashMap<>();
		Lemon.getInstance().getConfig().getConfigurationSection("Bans").getKeys(false).forEach(uuid -> add(UUID.fromString(uuid), Lemon.getInstance().getConfig().getLong("Bans." + uuid)));
	}

	public Map<UUID, Long> getBans() {
		return bans;
	}

	public void add(UUID uuid) {
		add(uuid, System.currentTimeMillis() + Lemon.getInstance().getConfig().getLong("Ban-Time"));
	}

	public void add(UUID uuid, long time) {
		getBans().put(uuid, time);
	}

	public void remove(UUID uuid) {
		getBans().remove(uuid);
	}

	public long getTime(UUID uuid) {
		return getBans().get(uuid);
	}

	public long deltaTime(UUID uuid) {
		return getTime(uuid) - System.currentTimeMillis();
	}
}
