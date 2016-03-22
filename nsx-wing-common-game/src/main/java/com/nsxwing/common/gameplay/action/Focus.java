package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.state.GameState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Focus implements Action {

	private PlayerAgent actionTaker;

	@Override
	public GameState execute(GameState gameState) {
		gameState.getPlayerAgents().stream()
				.filter(playerAgent -> actionTaker.getAgentId() == playerAgent.getAgentId())
				.forEach(playerAgent -> playerAgent.setFocusTokens(playerAgent.getFocusTokens() + 1));

		return gameState;
	}
}
