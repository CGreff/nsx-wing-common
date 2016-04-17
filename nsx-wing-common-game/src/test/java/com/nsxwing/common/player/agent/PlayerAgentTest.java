package com.nsxwing.common.player.agent;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.gameplay.meta.combat.FiringArc;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;
import static com.nsxwing.common.player.agent.PlayerAgent.ACTIVATION_ORDER_COMPARATOR;
import static com.nsxwing.common.player.agent.PlayerAgent.COMBAT_ORDER_COMPARATOR;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PlayerAgentTest {

	private PlayerAgent underTest;
	private PlayerAgent otherTest;

	private List<PlayerAgent> agentList;

	@Mock
	private Pilot pilot;

	@Mock
	private Pilot otherPilot;

	@Mock
	private Position position;

	@Mock
	private Coordinate topLeft;

	@Mock
	private Coordinate topRight;

	@Mock
	private Coordinate center;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new PlayerAgent(pilot, CHAMP, "bar", position, 0, 0, emptyList());
		otherTest = new PlayerAgent(otherPilot, SCRUB, "foo", position, 0, 0, emptyList());
		agentList = new ArrayList<>();

		doReturn(1).when(pilot).getPilotSkill();
		doReturn(9).when(otherPilot).getPilotSkill();

		mockCoordinates();
	}

	private void mockCoordinates() {
		Coordinate unneededCoords = mock(Coordinate.class);
		doReturn(center).when(position).getCenter();
		doReturn(asList(topLeft, topRight, unneededCoords, unneededCoords)).when(position).getBoxCoordinates(false);
	}

	@Test
	public void shouldSortByLowestPilotSkillForActivationComparator() {
		agentList.add(otherTest);
		agentList.add(underTest);
		List<PlayerAgent> result = agentList.stream().sorted(ACTIVATION_ORDER_COMPARATOR).collect(toList());

		assertThat(result, equalTo(asList(underTest, otherTest)));
	}

	@Test
	public void shouldSortByHighestPilotSkillForCombatComparator() {
		agentList.add(underTest);
		agentList.add(otherTest);
		List<PlayerAgent> result = agentList.stream().sorted(COMBAT_ORDER_COMPARATOR).collect(toList());

		assertThat(result, equalTo(asList(otherTest, underTest)));
	}

	//This is a not good test.
	@Test
	public void shouldReturnAFiringArcBasedOnPosition() {
		FiringArc result = underTest.determineFiringArc();

		assertThat(result, is(notNullValue()));
		verify(topLeft).getX();
		verify(topLeft).getY();
		verify(topRight).getX();
		verify(topRight).getY();
		verify(center, times(2)).getX();
		verify(center, times(2)).getY();
	}
}