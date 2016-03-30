package com.nsxwing.common.gameplay.meta.dice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.CRITICAL_HIT;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.NOTHING;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.SUCCESS;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DamageDeterminantTest {

	private List<AttackDie> attackDice;
	private List<EvadeDie> evadeDice;

	@Before
	public void setUp() {
		attackDice = new ArrayList<>();
		evadeDice = new ArrayList<>();
	}

	@Test
	public void shouldReturnAListOfDiceResults() {
		mockAttackDice(SUCCESS);
		mockEvadeDice(SUCCESS);

		List<DiceResult> result = DamageDeterminant.determineDamage(attackDice, evadeDice);

		assertThat(result, notNullValue());
	}

	@Test
	public void shouldReturnASingleSuccess() {
		mockAttackDice(SUCCESS);
		mockEvadeDice(NOTHING);

		List<DiceResult> result = DamageDeterminant.determineDamage(attackDice, evadeDice);

		assertThat(result, hasItem(SUCCESS));
	}

	@Test
	public void shouldReturnAnEmptyListWhenNoAttackGetsThrough() {
		mockAttackDice(NOTHING);
		mockEvadeDice(SUCCESS);

		List<DiceResult> result = DamageDeterminant.determineDamage(attackDice, evadeDice);

		assertThat(result.size(), is(0));
	}

	@Test
	public void shouldSortCriticalHitsWithHigherPriority() {
		mockAttackDice(SUCCESS, CRITICAL_HIT);
		mockEvadeDice(SUCCESS);

		List<DiceResult> result = DamageDeterminant.determineDamage(attackDice, evadeDice);

		assertThat(result, hasItem(CRITICAL_HIT));
	}

	private void mockAttackDice(DiceResult... results) {
		for (DiceResult result : results) {
			AttackDie die = mock(AttackDie.class);
			when(die.getResult()).thenReturn(result);
			attackDice.add(die);
		}
	}

	private void mockEvadeDice(DiceResult... results) {
		for (DiceResult result : results) {
			EvadeDie die = mock(EvadeDie.class);
			when(die.getResult()).thenReturn(result);
			evadeDice.add(die);
		}
	}
}