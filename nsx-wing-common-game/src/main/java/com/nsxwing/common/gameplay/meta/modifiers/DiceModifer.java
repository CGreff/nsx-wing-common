package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;

import java.util.List;

public interface DiceModifer {
	List<DiceResult> modify(List<DiceResult> diceResults);
}
