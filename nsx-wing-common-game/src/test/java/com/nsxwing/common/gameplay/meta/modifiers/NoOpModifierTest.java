package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.Die;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;

public class NoOpModifierTest {
	@InjectMocks
	private NoOpModifier underTest;

	@Mock
	private Die die;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnItsInputAndDoNothing() {
		List<Die> diceResults = singletonList(die);

		List<? extends Die> result = underTest.modify(diceResults);

		assertThat(result, is(diceResults));
		verifyZeroInteractions(die);
	}
}