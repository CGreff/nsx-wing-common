package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;

public class NoOpModifierTest {
	@InjectMocks
	private NoOpModifier underTest;

	@Mock
	private List<DiceResult> diceResults;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnItsInputAndDoNothing() {
		List<DiceResult> result = underTest.modify(diceResults);

		assertThat(result, is(diceResults));
		verifyZeroInteractions(diceResults);
	}
}