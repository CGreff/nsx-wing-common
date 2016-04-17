package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.state.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;

public class VoidTest {
	@InjectMocks
	private Void underTest;

	@Mock
	private GameState gameState;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldDoNothing() {
		assertThat(underTest.execute(gameState), is(gameState));
		verifyZeroInteractions(gameState);
	}
}