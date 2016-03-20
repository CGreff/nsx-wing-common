package com.nsxwing.common.player.agent;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.position.descriptor.Position;
import lombok.Data;

@Data
public class PlayerAgent {
	private Pilot pilot;
	private PlayerIdentifier owner;
	private int agentId;
	private Position position;
}
