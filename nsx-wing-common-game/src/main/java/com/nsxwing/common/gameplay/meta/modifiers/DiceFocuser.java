package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.Die;

import java.util.List;

public class DiceFocuser implements DiceModifer {
	@Override
	public List<Die> modify(List<Die> diceResults) {
		diceResults.stream().forEach(Die::focus);

		return  diceResults;
	}
}
