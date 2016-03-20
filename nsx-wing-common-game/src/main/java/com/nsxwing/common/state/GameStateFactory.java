package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;

public class GameStateFactory {

	private static final int INITIAL_TURN_NUMBER = 0;

	public GameState buildInitialGameState(Player champ, Player scrub) {
		List<PlayerAgent> agents = new ArrayList<>();
		addPlayerIdentifer(champ, CHAMP);
		addPlayerIdentifer(scrub, SCRUB);
		agents.addAll(champ.getPlayerAgents());
		agents.addAll(scrub.getPlayerAgents());

		return new GameState(agents, new HashMap<>(), INITIAL_TURN_NUMBER);
	}

	private void addPlayerIdentifer(Player player, PlayerIdentifier playerIdentifier) {
		player.getPlayerAgents().stream().forEach(playerAgent -> playerAgent.setOwner(playerIdentifier));
	}

	public GameState incrementTurn(GameState gameState) {
		return new GameState(
				gameState.getPlayerAgents(),
				gameState.getPlannedManeuvers(),
				gameState.getTurnNumber() + 1);
	}
}
