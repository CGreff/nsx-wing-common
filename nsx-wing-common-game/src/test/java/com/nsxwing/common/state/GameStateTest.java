package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.Maneuver;
import com.nsxwing.common.position.descriptor.Position;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameStateTest {

	private static final int INITIAL_TURN_NUMBER = 0;
	private GameState underTest;

	@Mock
	private Player champ;

	@Mock
	private Player scrub;

	@Mock
	private PlayerAgent champAgent;

	@Mock
	private PlayerAgent scrubAgent;

	@Mock
	private Maneuver maneuver;

	@Mock
	private Position position;


	private List<PlayerAgent> playerAgents;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		playerAgents = asList(champAgent, scrubAgent);

		underTest = buildGameState(playerAgents, INITIAL_TURN_NUMBER);

		mockAgents();
	}

	private GameState buildGameState(List<PlayerAgent> playerAgents, int turnNumber) {
		return new GameState(champ, scrub, playerAgents, null, turnNumber);
	}

	private void mockAgents() {
		doReturn(CHAMP).when(champAgent).getOwner();
		doReturn(0).when(champAgent).getAgentId();
		doReturn(SCRUB).when(scrubAgent).getOwner();
		doReturn(1).when(scrubAgent).getAgentId();
		doReturn(mock(Position.class)).when(champAgent).getPosition();
		doReturn(mock(Position.class)).when(scrubAgent).getPosition();
	}

	@Test
	public void shouldReturnGameIsIncompleteInNormalConditions() {
		assertFalse(underTest.isGameComplete());
	}

	@Test
	public void shouldReturnGameIsCompleteIfTurnLimitExceeded() {
		underTest = buildGameState(playerAgents, GameState.MAX_TURNS);

		assertTrue(underTest.isGameComplete());
	}

	@Test
	public void shouldReturnGameIsCompleteIfOnlyScrubHasAgents() {
		underTest = buildGameState(asList(scrubAgent), INITIAL_TURN_NUMBER);

		assertTrue(underTest.isGameComplete());
	}

	@Test
	public void shouldReturnGameIsCompleteIfOnlyChampHasAgents() {
		underTest = buildGameState(asList(champAgent), INITIAL_TURN_NUMBER);

		assertTrue(underTest.isGameComplete());
	}

	@Test
	public void shouldReturnTheCorrespondingPlayerForAnIdentifier() {
		assertThat(underTest.getPlayerFor(CHAMP), is(champ));
		assertThat(underTest.getPlayerFor(SCRUB), is(scrub));
	}

	@Test
	public void shouldApplyAManeuverToTheCorrectPlayerAgent() {
		doReturn(position).when(maneuver).move(any(Position.class));

		underTest.maneuverAgent(0, maneuver);

		verify(maneuver).move(champAgent.getPosition());
		verify(champAgent).setPosition(position);
	}
}