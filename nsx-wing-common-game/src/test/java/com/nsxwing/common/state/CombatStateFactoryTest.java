package com.nsxwing.common.state;

import com.nsxwing.common.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class CombatStateFactoryTest {
	@InjectMocks
	private CombatStateFactory underTest;

	@Mock
	private GameState gameState;

	@Mock
	private Player champ;

	@Mock
	private Player scrub;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		doReturn(champ).when(gameState).getChamp();
		doReturn(scrub).when(gameState).getScrub();
	}

	@Test
	public void shouldCreateANewCombatStateWithTheRequisitePlayers() {
		CombatState result = underTest.buildInitialCombatState(gameState);

		assertThat(result.getChamp(), is(champ));
		assertThat(result.getScrub(), is(scrub));
	}
}