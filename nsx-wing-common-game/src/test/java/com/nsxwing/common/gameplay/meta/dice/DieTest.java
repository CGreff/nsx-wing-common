package com.nsxwing.common.gameplay.meta.dice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.Consumer;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.NOTHING;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DieTest {

	private Die underTest;

	@Mock
	private Consumer<Void> roller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		underTest = new Die() {
			@Override
			protected void rollIt() {
				roller.accept(null);
				result = NOTHING;
			}
		};
	}

	@Test
	public void shouldRollADie() {
		underTest.roll();

		assertThat(underTest.getResult(), is(NOTHING));
		verify(roller, times(1)).accept(any());
	}

	@Test
	public void shouldRerollADie() {
		underTest.roll();
		underTest.roll();

		assertThat(underTest.getResult(), is(NOTHING));
		verify(roller, times(2)).accept(any());
	}

	@Test
	public void shouldOnlyRerollADieOnce() {
		underTest.roll();
		underTest.roll();
		underTest.roll();

		assertThat(underTest.getResult(), is(NOTHING));
		verify(roller, times(2)).accept(any());
	}

	@Test
	public void shouldTurnAFocusIntoASuccess() {
		underTest.result = DiceResult.FOCUS;

		underTest.focus();

		assertThat(underTest.getResult(), is(DiceResult.SUCCESS));
	}
}