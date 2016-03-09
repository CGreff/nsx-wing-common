package com.nsxwing.common.position;

import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;

/**
 * Implementation of Maneuver that does a 45 degree Bank turn, distance 1-3.
 */
public class BankTurn extends Maneuver {

    private double radius;

    public BankTurn(int distance, ManeuverDifficulty difficulty, Direction direction) {
        this.radius = 64 + (distance * 55);
        this.difficulty = difficulty;
        this.direction = direction;
    }

    @Override
    public Position move(Position position) {
        Position localPosition = rotatePosition(position, -position.getHeading());
        double heading = (direction == Direction.LEFT) ? -Math.PI / 4 : Math.PI / 4;

        double theta = (direction == Direction.LEFT) ? Math.PI / 4 : 3 * Math.PI / 4;
        double xModifier = (direction == Direction.LEFT) ? localPosition.getCenter().x - radius : localPosition.getCenter().x + radius;
        double yModifier = localPosition.getCenter().y;

        Position newLocalPosition = new Position(
                new Coordinate((radius * Math.cos(theta) + xModifier), (radius * Math.sin(theta) + yModifier)),
                (localPosition.getHeading() + heading) % (2 * Math.PI));

		return rotatePosition(newLocalPosition, position.getHeading());
    }
}