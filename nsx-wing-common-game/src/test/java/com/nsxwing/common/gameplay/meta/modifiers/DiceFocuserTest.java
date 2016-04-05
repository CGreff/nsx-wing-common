package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import com.nsxwing.common.gameplay.meta.dice.Die;
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
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class DiceFocuserTest {

	@InjectMocks
	private DiceFocuser underTest;

	@Mock
	private Die success;

	@Mock
	private Die focus;

	@Mock
	private Die nothing;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		doReturn(DiceResult.SUCCESS).when(success).getResult();
		doReturn(DiceResult.FOCUS).when(focus).getResult();
		doReturn(DiceResult.NOTHING).when(nothing).getResult();
	}

	@Test
	public void shouldAttemptToFocusAllDice() {
		List<Die> initialDice = asList(success, focus, nothing, focus);

		underTest.modify(initialDice);

		verify(focus, times(2)).focus();
		verify(success).focus();
		verify(nothing).focus();
	}
}