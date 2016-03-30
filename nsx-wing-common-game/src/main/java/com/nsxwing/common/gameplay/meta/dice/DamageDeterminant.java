package com.nsxwing.common.gameplay.meta.dice;

import java.util.List;

import static com.nsxwing.common.gameplay.meta.dice.DiceResult.NOTHING;
import static java.util.stream.Collectors.toList;

public class DamageDeterminant {

	public static List<DiceResult> determineDamage(List<AttackDie> attackDice, List<EvadeDie> evadeDice) {
		return attackDice.stream()
				.filter(DamageDeterminant::isSuccessful)
				.sorted(DamageDeterminant::diceSorter)
				.limit(determineNumberOfHits(attackDice, evadeDice))
				.map(Die::getResult)
				.collect(toList());
	}

	private static long determineNumberOfHits(List<AttackDie> attackDice, List<EvadeDie> evadeDice) {
		long successfulHits = getSuccessCount(attackDice) - getSuccessCount(evadeDice);
		return successfulHits < 0 ? 0 : successfulHits;
	}

	private static long getSuccessCount(List<? extends Die> dice) {
		return dice.stream()
				.filter(DamageDeterminant::isSuccessful)
				.count();
	}

	private static boolean isSuccessful(Die die) {
		return die.getResult() != NOTHING;
	}

	private static int diceSorter(Die die, Die otherDie) {
		return die.getResult().ordinal() - otherDie.getResult().ordinal();
	}
}
