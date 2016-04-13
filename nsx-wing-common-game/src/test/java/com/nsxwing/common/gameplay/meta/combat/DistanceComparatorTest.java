package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.position.descriptor.Coordinate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class DistanceComparatorTest {

	private DistanceComparator underTest;

	@Mock
	private Coordinate comparisonPoint;

	@Mock
	private Coordinate firstCoordinate;

	@Mock
	private Coordinate secondCoordinate;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new DistanceComparator(comparisonPoint);

		mockCoordinates();
	}

	private void mockCoordinates() {
		doReturn(1.0).when(comparisonPoint).getDistanceTo(firstCoordinate);
		doReturn(2.0).when(comparisonPoint).getDistanceTo(secondCoordinate);
	}

	@Test
	public void shouldHaveFirstCoordinateBeforeSecondCoordinate() {
		assertThat(underTest.compare(firstCoordinate, secondCoordinate), is(-1));
	}

	@Test
	public void shouldReturnTheOppositeWhenPassedInTheOppositeOrder() {
		assertThat(underTest.compare(secondCoordinate, firstCoordinate), is(1));
	}
}