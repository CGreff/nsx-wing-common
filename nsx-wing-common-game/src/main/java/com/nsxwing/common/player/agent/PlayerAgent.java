package com.nsxwing.common.player.agent;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.position.descriptor.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerAgent {
	private Pilot pilot;
	private PlayerIdentifier owner;
	private int agentId;
	private Position position;
	private int focusTokens;

	public static final Comparator<PlayerAgent> ACTIVATION_ORDER_COMPARATOR = (p1, p2) ->
			Integer.compare(p1.getPilot().getPilotSkill(), p2.getPilot().getPilotSkill());

	public static final Comparator<PlayerAgent> COMBAT_ORDER_COMPARATOR = (p1, p2) ->
			Integer.compare(p2.getPilot().getPilotSkill(), p1.getPilot().getPilotSkill());
}
