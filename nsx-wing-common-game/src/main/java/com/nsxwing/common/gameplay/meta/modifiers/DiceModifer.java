package com.nsxwing.common.gameplay.meta.modifiers;

import com.nsxwing.common.gameplay.meta.dice.Die;

import java.util.List;

public interface DiceModifer {
	List<Die> modify(List<Die> diceResults);
}
