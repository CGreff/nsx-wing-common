package com.nsxwing.common.position;

import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;

/**
 * Abstract class for describing a Maneuver object. Contains helpers that translate from local coordinates to global coordinates.
 */
abstract class Maneuver {

	protected Direction direction;
	protected ManeuverDifficulty difficulty;

	public abstract Position move(Position position);

	Position rotatePosition(Position position, double radiansCW) {
		return new Position(new Coordinate(
				position.getCenter().x * Math.cos(radiansCW) + position.getCenter().y * Math.sin(radiansCW),
				-position.getCenter().x * Math.sin(radiansCW) + position.getCenter().y * Math.cos(radiansCW)), position.getHeading());
	}
}
