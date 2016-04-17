package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Answers.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RangeFinderTest {

	private static final double RANGE_ONE_DISTANCE = 31.0;
	private static final double RANGE_TWO_DISTANCE = 150.0;
	private static final double RANGE_THREE_DISTANCE = 231.0;
	private RangeFinder underTest;

	@Mock
	private PlayerAgent playerAgent;

	@Mock
	private Position agentPosition;

	@Mock
	private Coordinate agentCoordinate;

	@Mock
	private Coordinate targetCoordinate;

	@Mock(answer = RETURNS_DEEP_STUBS)
	private PlayerAgent target;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(playerAgent.getPosition()).thenReturn(agentPosition);

		underTest = new RangeFinder(playerAgent);

		mockTarget();
		mockCoordinates();
	}

	private void mockCoordinates() {
		when(agentPosition.getCenter()).thenReturn(agentCoordinate);
		when(targetCoordinate.getDistanceTo(agentCoordinate)).thenReturn(RANGE_THREE_DISTANCE);
	}

	private void mockTarget() {
		when(target.getPilot().isHugeShip()).thenReturn(false);
		when(target.getPosition().getBoxCoordinates(false)).thenReturn(asList(targetCoordinate));
	}

	@Test
	public void shouldReturnARangeFinderGivenTheAgent() {
		RangeFinder result = new RangeFinder(playerAgent);

		assertThat(result, is(notNullValue()));
		//atLeastOnce() because it's already being constructed in the before block.
		verify(playerAgent, atLeastOnce()).getPosition();
	}

	@Test
	public void shouldReturnRangeOneToTarget() {
		when(targetCoordinate.getDistanceTo(agentCoordinate)).thenReturn(RANGE_ONE_DISTANCE);

		assertThat(underTest.getRangeToTarget(target), is(1));
	}

	@Test
	public void shouldReturnRangeTwoToTarget() {
		when(targetCoordinate.getDistanceTo(agentCoordinate)).thenReturn(RANGE_TWO_DISTANCE);

		assertThat(underTest.getRangeToTarget(target), is(2));
	}

	@Test
	public void shouldReturnRangeThreeToTarget() {
		when(targetCoordinate.getDistanceTo(agentCoordinate)).thenReturn(RANGE_THREE_DISTANCE);

		assertThat(underTest.getRangeToTarget(target), is(3));
	}
}