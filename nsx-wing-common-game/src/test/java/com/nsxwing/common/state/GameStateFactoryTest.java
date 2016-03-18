package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class GameStateFactoryTest {

	@InjectMocks
	private GameStateFactory underTest;

	@Mock
	private Player champ;
	@Mock
	private Player scrub;

	@Mock
	private PlayerAgent champAgent;
	@Mock
	private PlayerAgent scrubAgent;

	@Mock
	private GameState gameState;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		doReturn(0).when(gameState).getTurnNumber();
		mockPlayers();
	}

	private void mockPlayers() {
		doReturn(asList(champAgent)).when(champ).getPlayerAgents();
		doReturn(asList(scrubAgent)).when(scrub).getPlayerAgents();
		doReturn(CHAMP).when(champ).getIdentifier();
		doReturn(SCRUB).when(scrub).getIdentifier();
	}

	@Test
	public void shouldBuildInitialGameStateWithPlayers() {
		GameState expected = underTest.buildInitialGameState(champ, scrub);

		assertThat(expected.getPlayerAgents(), hasItem(scrubAgent));
		assertThat(expected.getPlayerAgents(), hasItem(champAgent));
		assertThat(expected.getTurnNumber(), is(0));
		verify(champAgent).setOwner(eq(CHAMP));
		verify(scrubAgent).setOwner(eq(SCRUB));
	}

	@Test
	public void shouldBuildWithAPreviousGameState() {
		GameState expected = underTest.incrementTurn(gameState);

		assertThat(expected.getTurnNumber(), is(1));
	}
}