package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.Die;

import java.util.List;

public class DiceFocuser implements DiceModifer {
	@Override
	public List<? extends Die> modify(List<? extends Die> diceResults) {
		diceResults.stream().forEach(Die::focus);

		return  diceResults;
	}
}
