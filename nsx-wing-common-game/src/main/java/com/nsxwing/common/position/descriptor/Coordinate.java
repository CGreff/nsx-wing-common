package com.nsxwing.common.position.descriptor;

import lombok.AllArgsConstructor;

/**
 * Simple class used to mark x and y coordinates of a point.
 */
public class Coordinate {
    public double x;
    public double y;

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
