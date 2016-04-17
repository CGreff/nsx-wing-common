package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.gameplay.meta.combat.TargetLock;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.state.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class LockTargetTest {

	private static final String AGENT_ID = "Cool Dude";

	private LockTarget underTest;

	@Mock
	private PlayerAgent actionTaker;

	@Mock
	private PlayerAgent gameStateActionTaker;

	@Mock
	private PlayerAgent target;

	@Mock
	private GameState gameState;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new LockTarget(actionTaker, target);

		doReturn(AGENT_ID).when(gameStateActionTaker).getAgentId();
		doReturn(AGENT_ID).when(actionTaker).getAgentId();
		doReturn(asList(gameStateActionTaker)).when(gameState).getPlayerAgents();
	}

	@Test
	public void shouldAddATargetLock() {
		underTest.execute(gameState);

		verify(gameStateActionTaker).addTargetLock(any(TargetLock.class));
	}
}