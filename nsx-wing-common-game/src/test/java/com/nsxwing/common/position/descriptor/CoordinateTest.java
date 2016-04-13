package com.nsxwing.common.position.descriptor;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoordinateTest {
	private Coordinate underTest;

	@Before
	public void setUp() {
		underTest = new Coordinate(0, 0);
	}

	@Test
	public void shouldReturnADistanceOf1() {
		assertThat(underTest.getDistanceTo(new Coordinate(1, 0)), is(1.0));
	}

	@Test
	public void shouldReturnADistanceOf2() {
		assertThat(underTest.getDistanceTo(new Coordinate(0, 2)), is(2.0));
	}
}