package com.nsxwing.common.state;

import com.nsxwing.common.player.agent.PlayerAgent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

public class GameStateTest {

	private static final int INITIAL_TURN_NUMBER = 0;
	private GameState underTest;

	@Mock
	private PlayerAgent champAgent;

	@Mock
	private PlayerAgent scrubAgent;

	private List<PlayerAgent> playerAgents;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		playerAgents = asList(champAgent, scrubAgent);

		underTest = buildGameState(playerAgents, INITIAL_TURN_NUMBER);

		mockAgents();
	}

	private GameState buildGameState(List<PlayerAgent> playerAgents, int turnNumber) {
		return new GameState(playerAgents, null, turnNumber);
	}

	private void mockAgents() {
		doReturn(CHAMP).when(champAgent).getOwner();
		doReturn(SCRUB).when(scrubAgent).getOwner();
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
}