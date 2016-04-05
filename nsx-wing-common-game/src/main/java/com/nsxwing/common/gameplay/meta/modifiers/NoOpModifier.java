package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import com.nsxwing.common.gameplay.meta.dice.Die;

import java.util.List;

public class NoOpModifier implements DiceModifer {
	@Override
	public List<Die> modify(List<Die> diceResults) {
		return diceResults;
	}
}
