package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.Die;

import java.util.List;

public class NoOpModifier implements DiceModifer {
	@Override
	public List<? extends Die> modify(List<? extends Die> diceResults) {
		return diceResults;
	}
}
