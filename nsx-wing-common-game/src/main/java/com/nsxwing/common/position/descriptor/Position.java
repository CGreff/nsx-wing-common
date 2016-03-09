package com.nsxwing.common.position.descriptor;

import lombok.Getter;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Marks a given ship position using the coordinates of its center.
 */
@Getter
public class Position {
	private Coordinate center;
	//in Radians, measured CW from X axis
	private double heading;

	public Position(Coordinate center, double heading) {
		this.center = center;
		this.heading = heading;
	}

	/*
	 * The "Box" Coordinates describe the coordinates for the 4 corners of the ship.
	 * Large Ships have a larger base so the coordinates are necessarily further from the center.
	 */
	public List<Coordinate> getBoxCoordinates(boolean isLargeShip) {
		int sizeMultiplier = isLargeShip ? 2 : 1;
		int boxOffset = 20 * sizeMultiplier;

		List<Coordinate> boxPoints = asList(
				new Coordinate(-boxOffset, boxOffset),
				new Coordinate(boxOffset, boxOffset),
				new Coordinate(boxOffset, -boxOffset),
				new Coordinate(-boxOffset, -boxOffset));

		boxPoints.forEach(this::translatePoint);

		return boxPoints;
	}

	private void translatePoint(Coordinate point) {
		double rotatedX = point.x * Math.cos(heading) + point.y * Math.sin(heading);
		double rotatedY = -point.x * Math.sin(heading) + point.y * Math.cos(heading);

		point.x = rotatedX + center.x;
		point.y = rotatedY + center.y;
	}
}
