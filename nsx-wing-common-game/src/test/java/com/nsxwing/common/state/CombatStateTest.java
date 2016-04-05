package com.nsxwing.common.state;

import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.player.agent.PlayerAgent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class CombatStateTest {

	@InjectMocks
	private CombatState underTest;

	@Mock
	private PlayerAgent attacker;

	@Mock
	private PlayerAgent defendingAgent;

	@Mock
	private Target defender;

	@Mock
	private Pilot pilot;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		doReturn(pilot).when(attacker).getPilot();
		doReturn(pilot).when(defendingAgent).getPilot();
		doReturn(defendingAgent).when(defender).getTargetAgent();
		doReturn(3).when(pilot).getAttack();
		doReturn(3).when(pilot).getEvade();
		doReturn(2).when(defender).getRange();
	}

	@Test
	public void shouldReturnAttackDiceEqualToTheAttackersAttackValue() {
		int result = underTest.determineAttackDice();

		assertThat(result, is(3));
	}

	@Test
	public void shouldIncrementAttackByOneWhenRangeOne() {
		doReturn(1).when(defender).getRange();

		int result = underTest.determineAttackDice();

		assertThat(result, is(4));
	}

	@Test
	public void shouldReturnEvadeDiceEqualToTheDefendersEvadeValue() {
		int result = underTest.determineEvadeDice();

		assertThat(result, is(3));
	}

	@Test
	public void shouldIncrementEvadeDiceAtRangeThree() {
		doReturn(3).when(defender).getRange();

		int result = underTest.determineEvadeDice();

		assertThat(result, is(4));
	}
}