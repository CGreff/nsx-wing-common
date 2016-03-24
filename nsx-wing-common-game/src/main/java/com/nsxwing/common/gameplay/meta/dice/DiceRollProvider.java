package com.nsxwing.common.gameplay.meta.dice;

import java.util.Random;

public abstract class DiceRollProvider {
	static double getRandomDouble() {
		return new Random().nextDouble() * 0.8;
	}

	@FunctionalInterface
	public interface RandomProvider {
		double getRandomDouble();
	}
}
