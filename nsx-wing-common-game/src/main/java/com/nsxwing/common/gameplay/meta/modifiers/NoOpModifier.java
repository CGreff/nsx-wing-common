package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;

import java.util.List;

public class NoOpModifier implements DiceModifer {
	@Override
	public List<DiceResult> modify(List<DiceResult> diceResults) {
		return diceResults;
	}
}
