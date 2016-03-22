package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.Maneuver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameState {
	protected static final int MAX_TURNS = 100;

	private Player champ;
	private Player scrub;
	private List<PlayerAgent> playerAgents;
	private Map<Integer, Maneuver> plannedManeuvers;
	private int turnNumber;

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

	public Player getPlayerFor(PlayerIdentifier identifier) {
		return identifier == PlayerIdentifier.CHAMP ? champ : scrub;
	}

	public void maneuverAgent(int agentIdentifier, Maneuver maneuver) {
		//forEach will always only get 1 playerAgent assuming Ids work as intended.
		playerAgents.stream()
				.filter((playerAgent -> playerAgent.getAgentId() == agentIdentifier))
				.forEach(playerAgent -> playerAgent.setPosition(maneuver.move(playerAgent.getPosition())));
	}
}
