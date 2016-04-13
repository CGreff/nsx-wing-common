package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.position.descriptor.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FiringLineTest {

	private FiringLine underTest;
	private Coordinate leftOfLineCoordinates = new Coordinate(0, 1);
	private Coordinate rightOfLineCoordinates = new Coordinate(1, 0);
	private Coordinate onTheLineCoordinates = new Coordinate(1, 1);

	@Before
	public void setUp() {
		//Draw a 45 degree line for the test
		underTest = new FiringLine(0, 0, 1, 1);
	}

	@Test
	public void shouldReturnLeftOfLineForCoordinateToItsLeft() {
		assertTrue(underTest.isLeftOfLine(leftOfLineCoordinates));
	}

	@Test
	public void shouldNotReturnRightOfLineForCoordinateToItsLeft() {
		assertFalse(underTest.isRightOfLine(leftOfLineCoordinates));
	}

	@Test
	public void shouldReturnRightOfLineForCoordinateToItsRight() {
		assertTrue(underTest.isRightOfLine(rightOfLineCoordinates));
	}

	@Test
	public void shouldNotReturnLeftOfLineForCoordinateToItsRight() {
		assertFalse(underTest.isLeftOfLine(rightOfLineCoordinates));
	}

	@Test
	public void shouldReturnBothLeftAndRightOfLineWhenDirectlyOnLine() {
		assertTrue(underTest.isLeftOfLine(onTheLineCoordinates));
		assertTrue(underTest.isRightOfLine(onTheLineCoordinates));
	}
}