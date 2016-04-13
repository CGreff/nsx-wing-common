package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.position.descriptor.Coordinate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FiringLine {
	private double originX;
	private double originY;
	private double lineX;
	private double lineY;

	public boolean isLeftOfLine(Coordinate coordinate) {
		return getDeterminant(coordinate) >= 0;
	}

	public boolean isRightOfLine(Coordinate coordinate) {
		return getDeterminant(coordinate) <= 0;
	}

	/*
	 * Gathered with: position = sign( (Bx-Ax)*(Y-Ay) - (By-Ay)*(X-Ax) )
	 * Sign is positive = left of line; negative = right of line.
	 */
	private double getDeterminant(Coordinate coordinate) {
		return ((lineX - originX) * (coordinate.y - originY) - (lineY - originY) * (coordinate.x - originX));
	}
}
