package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.player.PlayerIdentifier;

public class EndAttackResponse extends GameResponse {

	public EndAttackResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
