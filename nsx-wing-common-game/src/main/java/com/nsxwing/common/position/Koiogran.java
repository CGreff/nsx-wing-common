package com.nsxwing.common.position;

import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;

/**
 * Implementation of Maneuver that does a K-turn with distance 1-5 (due to pilot abilities).
 */
public class Koiogran extends Maneuver {

	private double moveDistance;

	public Koiogran(int distance, ManeuverDifficulty difficulty) {
		this.moveDistance = distance * 40 + 40;
		this.difficulty = difficulty;
	}

	@Override
	public Position move(Position position) {
		Position localPosition = rotatePosition(position, -position.getHeading());
		Position newLocalPosition = new Position(new Coordinate(localPosition.getCenter().x, localPosition.getCenter().y + moveDistance),
				(localPosition.getHeading() + Math.PI) % (2 * Math.PI));

		return rotatePosition(newLocalPosition, position.getHeading());
	}
}


