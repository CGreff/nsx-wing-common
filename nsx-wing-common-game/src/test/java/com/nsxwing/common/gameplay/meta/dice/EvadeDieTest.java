package com.nsxwing.common.gameplay.meta.dice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.FOCUS;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.NOTHING;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.SUCCESS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class EvadeDieTest {

	private static final int N = 5;

	@InjectMocks
	private EvadeDie underTest;

	@Mock
	private DiceRollProvider diceRollProvider;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnSuccessIfLessThan3() {
		doReturn(0.29).when(diceRollProvider).getRandomDouble();

		underTest.rollIt();

		assertThat(underTest.getResult(), is(SUCCESS));
	}

	@Test
	public void shouldReturnFocusIfLessThan5() {
		doReturn(0.49).when(diceRollProvider).getRandomDouble();

		underTest.rollIt();

		assertThat(underTest.getResult(), is(FOCUS));
	}

	@Test
	public void shouldReturnNothingInAllOtherCases() {
		doReturn(0.5).when(diceRollProvider).getRandomDouble();

		underTest.rollIt();

		assertThat(underTest.getResult(), is(NOTHING));
	}

	@Test
	public void shouldReturnNEvadeDice() {
		List<EvadeDie> dice = EvadeDie.getDice(N);

		assertThat(dice.size(), is(N));
	}
}