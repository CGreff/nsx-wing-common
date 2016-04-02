package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.gameplay.meta.modifiers.DiceModifer;
import com.nsxwing.common.player.PlayerIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyAttackResponse extends GameResponse {
	private DiceModifer diceModifer;

	public ModifyAttackResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
