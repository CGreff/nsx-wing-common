package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.Maneuver;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;

@Data
@NoArgsConstructor
public class GameState extends PlayerHandlingState {
	protected static final int MAX_TURNS = 100;

	private List<PlayerAgent> playerAgents;
	private Map<String, Maneuver> plannedManeuvers;
	private int turnNumber;

	public GameState(Player champ, Player scrub, List<PlayerAgent> playerAgents, Map<String, Maneuver> plannedManeuvers, int turnNumber) {
		this.champ = champ;
		this.scrub = scrub;
		this.playerAgents = playerAgents;
		this.plannedManeuvers = plannedManeuvers;
		this.turnNumber = turnNumber;
	}

	public boolean isGameComplete() {
		return turnNumber >= MAX_TURNS ||
				playerAgents.stream().noneMatch(this::isChampAgent) ||
				playerAgents.stream().noneMatch(this::isScrubAgent);
	}

	private boolean isChampAgent(PlayerAgent playerAgent) {
		return playerAgent.getOwner() == CHAMP;
	}

	private boolean isScrubAgent(PlayerAgent playerAgent) {
		return playerAgent.getOwner() == SCRUB;
	}

	public void maneuverAgent(String agentIdentifier, Maneuver maneuver) {
		playerAgents.stream()
				.filter((playerAgent -> playerAgent.getAgentId().equals(agentIdentifier)))
				.forEach(playerAgent -> playerAgent.setPosition(maneuver.move(playerAgent.getPosition())));
	}
}
