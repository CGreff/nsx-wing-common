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

public class FocusTest {

	private static final String AGENT_ID = "super rad agent";
	private static final int CURRENT_FOCUS_TOKENS = 6;

	@InjectMocks
	private Focus underTest;

	@Mock
	private PlayerAgent actionTaker;

	@Mock
	private GameState gameState;

	@Mock
	private PlayerAgent gameStateActionTaker;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new Focus(actionTaker);

		doReturn(CURRENT_FOCUS_TOKENS).when(gameStateActionTaker).getFocusTokens();
		doReturn(AGENT_ID).when(gameStateActionTaker).getAgentId();
		doReturn(AGENT_ID).when(actionTaker).getAgentId();
		doReturn(asList(gameStateActionTaker)).when(gameState).getPlayerAgents();
	}

	@Test
	public void shouldIncrementTheFocusTokensForTheActioneer() {
		underTest.execute(gameState);

		verify(gameStateActionTaker).setFocusTokens(CURRENT_FOCUS_TOKENS + 1);
	}
}