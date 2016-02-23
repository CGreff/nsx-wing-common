package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.player.PlayerIdentifier;

public abstract class GameResponse {

	PlayerIdentifier playerIdentifier;

	public PlayerIdentifier getPlayerIdentifier() {
		return playerIdentifier;
	}
}
