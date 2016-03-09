package com.nsxwing.common.position;

import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;

/**
 * Implementation of the Hard Turn that goes 1-3 distance.
 */
public class Turn extends Maneuver {

    double radius;

    public Turn(int distance, ManeuverDifficulty difficulty, Direction direction) {
        this.radius = 28.28427124746191 + (distance * 28.28427124746191);
        this.difficulty = difficulty;
        this.direction = direction;
    }

    @Override
    public Position move(Position position) {
        Position localPosition = rotatePosition(position, -position.getHeading());
        double heading = (direction == Direction.LEFT) ? -Math.PI / 2 : Math.PI / 2;

        double theta = (direction == Direction.LEFT) ? -(3 * Math.PI / 2) : Math.PI / 2;
        double xModifier = (direction == Direction.LEFT) ? localPosition.getCenter().x - radius : localPosition.getCenter().x + radius;
        double yModifier = localPosition.getCenter().y;

        Position newLocalPosition = new Position(new Coordinate((radius * Math.cos(theta) + xModifier), (radius * Math.sin(theta) + yModifier)),
                (localPosition.getHeading() + heading) % (2 * Math.PI));

        return rotatePosition(newLocalPosition, position.getHeading());
    }
}
