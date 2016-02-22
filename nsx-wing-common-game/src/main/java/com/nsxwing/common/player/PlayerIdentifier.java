package com.nsxwing.common.player;

import com.nsxwing.common.exception.PlayerAlreadySetException;
import com.nsxwing.common.exception.PlayerNotSetException;

public class PlayerIdentifier {

	public static PlayerName PLAYER_ID;


	public static PlayerName getPlayerId() {
		if (PLAYER_ID == null) {
			throw new PlayerNotSetException();
		}

		return PLAYER_ID;
	}

	public static void setPlayerId(PlayerName playerId) {
		if (PLAYER_ID != null) {
			throw new PlayerAlreadySetException();
		}

		PLAYER_ID = playerId;
	}
}
