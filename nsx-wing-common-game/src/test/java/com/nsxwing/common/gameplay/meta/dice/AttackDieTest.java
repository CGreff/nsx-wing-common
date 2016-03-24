package com.nsxwing.common.gameplay.meta.dice;

import com.nsxwing.common.gameplay.meta.dice.DiceRollProvider.RandomProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.CRITICAL_HIT;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.FOCUS;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.NOTHING;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.SUCCESS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class AttackDieTest {

	private static final int N = 5;

	@InjectMocks
	private AttackDie underTest;

	@Mock
	private RandomProvider diceRollProvider;

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
	public void shouldReturnCritIfLessThan4() {
		doReturn(0.39).when(diceRollProvider).getRandomDouble();

		underTest.rollIt();

		assertThat(underTest.getResult(), is(CRITICAL_HIT));
	}

	@Test
	public void shouldReturnFocusIfLessThan6() {
		doReturn(0.59).when(diceRollProvider).getRandomDouble();

		underTest.rollIt();

		assertThat(underTest.getResult(), is(FOCUS));
	}

	@Test
	public void shouldReturnNothingInAllOtherCases() {
		doReturn(0.6).when(diceRollProvider).getRandomDouble();

		underTest.rollIt();

		assertThat(underTest.getResult(), is(NOTHING));
	}

	@Test
	public void shouldReturnNAttackDice() {
		List<AttackDie> dice = AttackDie.getDice(N);

		assertThat(dice.size(), is(N));
	}
}