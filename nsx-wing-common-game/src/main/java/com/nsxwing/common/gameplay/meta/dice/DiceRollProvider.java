package com.nsxwing.common.gameplay.meta.dice;

import java.util.Random;

public class DiceRollProvider {
	public double getRandomDouble() {
		return new Random().nextDouble() * 0.8;
	}
}
