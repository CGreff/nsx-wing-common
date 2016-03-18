package com.nsxwing.common.state;

import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;

@Data
@Builder
public class GameState {
	protected static final int MAX_TURNS = 100;
	private List<PlayerAgent> playerAgents;
	private int turnNumber;

	public boolean isGameComplete() {
		return turnNumber >= 100 ||
				playerAgents.stream().noneMatch(this::isChampAgent) ||
				playerAgents.stream().noneMatch(this::isScrubAgent);
	}

	private boolean isChampAgent(PlayerAgent playerAgent) {
		return playerAgent.getOwner() == CHAMP;
	}

	private boolean isScrubAgent(PlayerAgent playerAgent) {
		return playerAgent.getOwner() == SCRUB;
	}
}
