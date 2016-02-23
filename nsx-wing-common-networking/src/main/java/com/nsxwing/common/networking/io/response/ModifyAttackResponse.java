package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.player.PlayerIdentifier;

public class ModifyAttackResponse extends GameResponse {

	public ModifyAttackResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
