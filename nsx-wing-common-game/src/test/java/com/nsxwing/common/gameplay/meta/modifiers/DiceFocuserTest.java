package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.CRITICAL_HIT;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.FOCUS;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.NOTHING;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.SUCCESS;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class DiceFocuserTest {

	private DiceFocuser underTest;

	private List<DiceResult> initialDice;

	@Before
	public void setUp() {
		underTest = new DiceFocuser();
	}

	@Test
	public void shouldChangeAllFocusResultsToSuccessResults() {
		initialDice = asList(SUCCESS, FOCUS, NOTHING, FOCUS);

		List<DiceResult> results = underTest.modify(initialDice);

		assertThat(results, hasItems(SUCCESS, SUCCESS, NOTHING, SUCCESS));
	}

	@Test
	public void shouldLeaveNonFocusedResultsUnchanged() {
		initialDice = asList(NOTHING, CRITICAL_HIT);

		List<DiceResult> results = underTest.modify(initialDice);

		assertThat(results, equalTo(initialDice));
	}
}