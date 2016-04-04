package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.Data;

@Data
public abstract class PlayerHandlingState {

	protected Player champ;
	protected Player scrub;

	public Player getPlayerFor(PlayerIdentifier identifier) {
		return identifier == PlayerIdentifier.CHAMP ? champ : scrub;
	}

	public Player getPlayerFor(PlayerAgent agent) {
		return getPlayerFor(agent.getOwner());
	}
}
