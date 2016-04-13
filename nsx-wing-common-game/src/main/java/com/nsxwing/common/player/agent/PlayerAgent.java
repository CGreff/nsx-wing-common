package com.nsxwing.common.player.agent;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.gameplay.meta.combat.FiringArc;
import com.nsxwing.common.gameplay.meta.combat.FiringLine;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerAgent {
	private Pilot pilot;
	private PlayerIdentifier owner;
	private String agentId;
	private Position position;
	private int focusTokens;

	public static final Comparator<PlayerAgent> ACTIVATION_ORDER_COMPARATOR = (p1, p2) ->
			Integer.compare(p1.getPilot().getPilotSkill(), p2.getPilot().getPilotSkill());

	public static final Comparator<PlayerAgent> COMBAT_ORDER_COMPARATOR = (p1, p2) ->
			Integer.compare(p2.getPilot().getPilotSkill(), p1.getPilot().getPilotSkill());

	/*
	 * The Firing Arc is composed of the line drawn from the origin to the top left corner of the position, and
	 * the line drawn from the origin to the top right corner of the position. These are the '0' and '1' indices
	 * in the Box Coordinates respectively.
	 */
	//TODO: Test drive when it is not past midnight
	public FiringArc determineFiringArc() {
		List<Coordinate> boxCoordinates = position.getBoxCoordinates(pilot.isHugeShip());

		return new FiringArc(
				new FiringLine(position.getCenter().x, position.getCenter().y, boxCoordinates.get(0).x, boxCoordinates.get(0).y),
				new FiringLine(position.getCenter().x, position.getCenter().y, boxCoordinates.get(1).x, boxCoordinates.get(1).y)
		);
	}

	public void sufferDamage(boolean isCritical) {

	}
}
