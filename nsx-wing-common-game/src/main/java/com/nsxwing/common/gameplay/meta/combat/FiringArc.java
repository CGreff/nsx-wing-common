package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.position.descriptor.Coordinate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FiringArc {
	private FiringLine leftFiringLine;
	private FiringLine rightFiringLine;

	//TODO: Take a position and target each box coordinate instead
	public boolean isTargetable(Coordinate targetCoordinate) {
		return leftFiringLine.isRightOfLine(targetCoordinate) && rightFiringLine.isLeftOfLine(targetCoordinate);
	}
}
