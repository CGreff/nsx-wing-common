package com.nsxwing.common.state;

import com.nsxwing.common.gameplay.meta.combat.TargetFinder;
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
		return buildInitialGameState(champ, scrub, 100);
	}

	public GameState buildInitialGameState(Player champ, Player scrub, int maxTurns) {
		List<PlayerAgent> agents = new ArrayList<>();
		addPlayerIdentifier(champ, CHAMP);
		addPlayerIdentifier(scrub, SCRUB);
		agents.addAll(champ.getPlayerAgents());
		agents.addAll(scrub.getPlayerAgents());

		GameState.MAX_TURNS = maxTurns;
		return new GameState(champ, scrub, agents, new HashMap<>(), INITIAL_TURN_NUMBER);
	}

	private void addPlayerIdentifier(Player player, PlayerIdentifier playerIdentifier) {
		player.getPlayerAgents().stream().forEach(playerAgent -> playerAgent.setOwner(playerIdentifier));
	}

	public GameState incrementTurn(GameState gameState) {
		return new GameState(
				gameState.getChamp(),
				gameState.getScrub(),
				gameState.getPlayerAgents(),
				gameState.getPlannedManeuvers(),
				gameState.getTurnNumber() + 1);
	}
}
