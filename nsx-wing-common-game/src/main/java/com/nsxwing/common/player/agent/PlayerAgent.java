package com.nsxwing.common.player.agent;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.player.PlayerIdentifier;
import lombok.Data;
import lombok.experimental.NonFinal;

@Data
public class PlayerAgent {
	private Pilot pilot;
	private PlayerIdentifier owner;
}
