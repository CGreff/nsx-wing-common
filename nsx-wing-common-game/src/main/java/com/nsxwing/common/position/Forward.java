package com.nsxwing.common.position;

import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;

/**
 * Implementation of Maneuver that goes forward 1-5 distance.
 */
public class Forward extends Maneuver {

    private double moveDistance;

    public Forward(int distance, ManeuverDifficulty difficulty) {
        this.moveDistance = distance * 40 + 40;
        this.difficulty = difficulty;
    }

    @Override
    public Position move(Position position) {
        Position localPosition = rotatePosition(position, -position.getHeading());
        Position newLocalPosition = new Position(new Coordinate(localPosition.getCenter().x, localPosition.getCenter().y + moveDistance),
                localPosition.getHeading());

        return rotatePosition(newLocalPosition, position.getHeading());
    }
}