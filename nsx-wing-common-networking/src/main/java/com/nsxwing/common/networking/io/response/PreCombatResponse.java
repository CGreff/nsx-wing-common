package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.player.PlayerIdentifier;

public class PreCombatResponse extends GameResponse {

	public PreCombatResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
