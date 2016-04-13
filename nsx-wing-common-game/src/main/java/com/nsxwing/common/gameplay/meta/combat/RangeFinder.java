package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RangeFinder {

	private Position agentPosition;

	public int getRangeToTarget(PlayerAgent target) {
		Coordinate closestPoint = findClosestPoint(target.getPosition().getBoxCoordinates(target.getPilot().isHugeShip()),
				agentPosition.getCenter());

		return (int) Math.ceil(closestPoint.getDistanceTo(agentPosition.getCenter()) / 100.0);
	}

	private Coordinate findClosestPoint(List<Coordinate> boxPoints, Coordinate centerPoint) {
		DistanceComparator distanceComparator = new DistanceComparator(centerPoint);
		return boxPoints.stream()
				.sorted(distanceComparator::compare)
				.findFirst()
				.get();
	}
}
