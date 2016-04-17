package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.gameplay.meta.combat.TargetLock;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.state.GameState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LockTarget implements Action {

	private PlayerAgent actionTaker;
	private PlayerAgent target;

	@Override
	public GameState execute(GameState gameState) {
		gameState.getPlayerAgents().stream()
				.filter(playerAgent -> matchPlayerAgent(actionTaker, playerAgent))
				.forEach(playerAgent -> playerAgent.addTargetLock(makeTargetLock()));

		return gameState;
	}

	private TargetLock makeTargetLock() {
		return new TargetLock(target);
	}
}
