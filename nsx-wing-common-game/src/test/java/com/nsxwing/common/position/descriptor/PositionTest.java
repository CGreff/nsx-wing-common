package com.nsxwing.common.position.descriptor;

import org.junit.Test;

import java.util.List;

public class PositionTest {

	private Position underTest;
	//Because floating point arithmetic - we want a tolerance for what a correct answer is.
	private static final float EPSILON = 0.00001f;

	@Test
	public void shouldGetCorrectBoxPointsForOriginNoRotation() {
		underTest = new Position(new Coordinate(0, 0), 0);
		List<Coordinate> boxPoints = underTest.getBoxCoordinates(false);

		int offset = 20;
		assert Math.abs(boxPoints.get(0).x + offset) < EPSILON;
		assert Math.abs(boxPoints.get(0).y - offset) < EPSILON;
		assert Math.abs(boxPoints.get(1).x - offset) < EPSILON;
		assert Math.abs(boxPoints.get(1).y - offset) < EPSILON;
		assert Math.abs(boxPoints.get(2).x - offset) < EPSILON;
		assert Math.abs(boxPoints.get(2).y + offset) < EPSILON;
		assert Math.abs(boxPoints.get(3).x + offset) < EPSILON;
		assert Math.abs(boxPoints.get(3).y + offset) < EPSILON;
	}

	@Test
	public void shouldGetCorrectBoxPointsForOriginNoRotationLargeShip() {
		underTest = new Position(new Coordinate(0, 0), 0);
		List<Coordinate> boxPoints = underTest.getBoxCoordinates(true);

		int offset = 40;
		assert Math.abs(boxPoints.get(0).x + offset) < EPSILON;
		assert Math.abs(boxPoints.get(0).y - offset) < EPSILON;
		assert Math.abs(boxPoints.get(1).x - offset) < EPSILON;
		assert Math.abs(boxPoints.get(1).y - offset) < EPSILON;
		assert Math.abs(boxPoints.get(2).x - offset) < EPSILON;
		assert Math.abs(boxPoints.get(2).y + offset) < EPSILON;
		assert Math.abs(boxPoints.get(3).x + offset) < EPSILON;
		assert Math.abs(boxPoints.get(3).y + offset) < EPSILON;
	}

	@Test
	public void shouldGetCorrectBoxPointsForOriginWithRotation() {
		underTest = new Position(new Coordinate(0, 0), Math.PI/4);
		List<Coordinate> boxPoints = underTest.getBoxCoordinates(false);

		assert Math.abs(boxPoints.get(0).x) < EPSILON;
		double offset = 28.284271247461902;
		assert Math.abs(boxPoints.get(0).y - offset) < EPSILON;
		assert Math.abs(boxPoints.get(1).x - offset) < EPSILON;
		assert Math.abs(boxPoints.get(1).y) < EPSILON;
		assert Math.abs(boxPoints.get(2).x) < EPSILON;
		assert Math.abs(boxPoints.get(2).y + offset) < EPSILON;
		assert Math.abs(boxPoints.get(3).x + offset) < EPSILON;
		assert Math.abs(boxPoints.get(3).y) < EPSILON;
	}

	@Test
	public void shouldGetCorrectBoxPointsForNonOriginWithRotation() {
		underTest = new Position(new Coordinate(40, 80), Math.PI/4);
		List<Coordinate> boxPoints = underTest.getBoxCoordinates(false);

		assert Math.abs(boxPoints.get(0).x - 40) < EPSILON;
		assert Math.abs(boxPoints.get(0).y - 108.284271247461902) < EPSILON;
		assert Math.abs(boxPoints.get(1).x - 68.284271247461902) < EPSILON;
		assert Math.abs(boxPoints.get(1).y - 80) < EPSILON;
		assert Math.abs(boxPoints.get(2).x - 40) < EPSILON;
		assert Math.abs(boxPoints.get(2).y - 51.7157287525381) < EPSILON;
		assert Math.abs(boxPoints.get(3).x - 11.7157287525381) < EPSILON;
		assert Math.abs(boxPoints.get(3).y - 80) < EPSILON;
	}
}