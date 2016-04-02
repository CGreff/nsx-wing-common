package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;

import java.util.List;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.FOCUS;
import static com.nsxwing.common.gameplay.meta.dice.DiceResult.SUCCESS;
import static java.util.stream.Collectors.toList;

public class DiceFocuser implements DiceModifer {
	@Override
	public List<DiceResult> modify(List<DiceResult> diceResults) {
		return diceResults.stream()
				.map(this::mapDiceResult)
				.collect(toList());
	}

	private DiceResult mapDiceResult(DiceResult diceResult) {
		return diceResult == FOCUS ? SUCCESS : diceResult;
	}
}
