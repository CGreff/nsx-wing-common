package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.gameplay.meta.modifiers.DiceModifer;
import com.nsxwing.common.player.PlayerIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ModifyAttackResponse extends GameResponse {
	private List<DiceModifer> diceModifiers;

	public ModifyAttackResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
