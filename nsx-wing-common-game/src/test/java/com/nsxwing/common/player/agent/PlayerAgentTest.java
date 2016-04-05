package com.nsxwing.common.player.agent;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.player.PlayerIdentifier;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;
import static com.nsxwing.common.player.agent.PlayerAgent.ACTIVATION_ORDER_COMPARATOR;
import static com.nsxwing.common.player.agent.PlayerAgent.COMBAT_ORDER_COMPARATOR;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class PlayerAgentTest {

	private PlayerAgent underTest;
	private PlayerAgent otherTest;

	private List<PlayerAgent> agentList;

	@Mock
	private Pilot pilot;

	@Mock
	private Pilot otherPilot;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new PlayerAgent(pilot, CHAMP, "bar", null, 0);
		otherTest = new PlayerAgent(otherPilot, SCRUB, "foo", null, 0);
		agentList = new ArrayList<>();

		doReturn(1).when(pilot).getPilotSkill();
		doReturn(9).when(otherPilot).getPilotSkill();
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
}