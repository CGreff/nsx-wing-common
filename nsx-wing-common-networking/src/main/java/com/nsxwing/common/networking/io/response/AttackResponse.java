package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.player.PlayerIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AttackResponse extends GameResponse {
	private Target target;

	public AttackResponse(PlayerIdentifier playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}
}
