package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.position.descriptor.Coordinate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DistanceComparator {

	private Coordinate comparisonPoint;

	public int compare(Coordinate firstCoordinate, Coordinate secondCoordinate) {
		return comparisonPoint.getDistanceTo(firstCoordinate) < comparisonPoint.getDistanceTo(secondCoordinate) ? -1 : 1;
	}
}
