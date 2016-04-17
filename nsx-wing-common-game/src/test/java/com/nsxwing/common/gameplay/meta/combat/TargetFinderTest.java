package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class TargetFinderTest {
	@InjectMocks
	private TargetFinder underTest;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private PlayerAgent champAgent;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private PlayerAgent scrubAgent;

	@Mock
	private RangeFinder rangeFinder;

	@Mock
	private FiringArc firingArc;

	@Mock
	private Position position;

	@Mock
	private Coordinate coordinate;

	private List<PlayerAgent> playerAgents;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		playerAgents = asList(champAgent, scrubAgent);

		mockAgents();
		mockRangeAndPosition();
	}

	private void mockRangeAndPosition() {
		doReturn(coordinate).when(position).getCenter();
		doReturn(true).when(firingArc).isTargetable(coordinate);
		doReturn(1).when(rangeFinder).getRangeToTarget(scrubAgent);
	}

	private void mockAgents() {
		doReturn(firingArc).when(champAgent).determineFiringArc();
		doReturn(CHAMP).when(champAgent).getOwner();
		doReturn(SCRUB).when(scrubAgent).getOwner();
		doReturn(position).when(scrubAgent).getPosition();
	}

	@Test
	public void shouldReturnAgentsThatAreNotTheTargetter() {
		List<Target> result = underTest.findTargets(champAgent, rangeFinder, playerAgents);

		assertThat(result.size(), is(1));
		assertThat(result.get(0).getTargetAgent(), is(scrubAgent));
	}

	@Test
	public void shouldReturnAgentsThatAreWithinTheFiringArc() {
		List<Target> result = underTest.findTargets(champAgent, rangeFinder, playerAgents);

		assertThat(result.size(), is(1));
		assertThat(result.get(0).getTargetAgent(), is(scrubAgent));
		verify(champAgent).determineFiringArc();
		verify(firingArc).isTargetable(coordinate);
	}

	@Test
	public void shouldNotIncludeAgentsThatAreBeyondRange3() {
		doReturn(4).when(rangeFinder).getRangeToTarget(scrubAgent);

		List<Target> result = underTest.findTargets(champAgent, rangeFinder, playerAgents);

		assertThat(result.size(), is(0));
		verify(rangeFinder).getRangeToTarget(scrubAgent);
	}
}