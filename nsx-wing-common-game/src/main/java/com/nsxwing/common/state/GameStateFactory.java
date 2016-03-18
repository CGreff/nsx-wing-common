package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;

import java.util.ArrayList;
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

		return GameState.builder()
				.playerAgents(agents)
				.turnNumber(INITIAL_TURN_NUMBER)
				.build();
	}

	private void addPlayerIdentifer(Player player, PlayerIdentifier playerIdentifier) {
		player.getPlayerAgents().stream().forEach(playerAgent -> playerAgent.setOwner(playerIdentifier));
	}

	public GameState incrementTurn(GameState gameState) {
		return GameState.builder()
				.turnNumber(gameState.getTurnNumber() + 1)
				.playerAgents(gameState.getPlayerAgents())
				.build();
	}
}
