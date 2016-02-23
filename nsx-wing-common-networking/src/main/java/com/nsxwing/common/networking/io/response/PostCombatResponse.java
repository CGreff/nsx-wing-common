package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.player.PlayerIdentifier;

public class PostCombatResponse extends GameResponse {

	public PostCombatResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
