package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.Data;

import java.util.List;

@Data
public class ConnectionEvent implements GameEvent {
	private List<PlayerAgent> playerAgents;
}
