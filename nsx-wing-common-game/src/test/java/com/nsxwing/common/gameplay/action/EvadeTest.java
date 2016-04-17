package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.state.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class EvadeTest {
	private static final String AGENT_ID = "super rad agent";
	private static final int CURRENT_EVADE_TOKENS = 3;

	private Evade underTest;

	@Mock
	private PlayerAgent actionTaker;

	@Mock
	private GameState gameState;

	@Mock
	private PlayerAgent gameStateActionTaker;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new Evade(actionTaker);

		doReturn(CURRENT_EVADE_TOKENS).when(gameStateActionTaker).getEvadeTokens();
		doReturn(AGENT_ID).when(gameStateActionTaker).getAgentId();
		doReturn(AGENT_ID).when(actionTaker).getAgentId();
		doReturn(asList(gameStateActionTaker)).when(gameState).getPlayerAgents();
	}

	@Test
	public void shouldIncrementTheFocusTokensForTheActioneer() {
		underTest.execute(gameState);

		verify(gameStateActionTaker).setEvadeTokens(CURRENT_EVADE_TOKENS + 1);
	}
}