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
import static org.mockito.Mockito.verify;

public class FiringArcTest {

	private FiringArc underTest;

	@Mock
	private FiringLine leftFiringLine;

	@Mock
	private FiringLine rightFiringLine;

	@Mock
	private Coordinate targetCoordinate;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new FiringArc(leftFiringLine, rightFiringLine);

		mockFiringLines();
	}

	private void mockFiringLines() {
		doReturn(true).when(leftFiringLine).isRightOfLine(targetCoordinate);
		doReturn(true).when(rightFiringLine).isLeftOfLine(targetCoordinate);
	}

	@Test
	public void shouldAppropriatelyFindATargetBetweenTheFiringLines() {
		assertThat(underTest.isTargetable(targetCoordinate), is(true));

		verify(leftFiringLine).isRightOfLine(targetCoordinate);
		verify(rightFiringLine).isLeftOfLine(targetCoordinate);
	}

}