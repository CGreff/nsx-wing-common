package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.state.GameState;

public interface Action {
	GameState execute(GameState gameState);

	default boolean matchPlayerAgent(PlayerAgent actionTaker, PlayerAgent otherAgent) {
		return otherAgent.getAgentId().equals(actionTaker.getAgentId());
	}
}
