package com.nsxwing.common.gameplay.meta.dice;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class AttackDie extends Die {
	private DiceRollProvider diceRollProvider = new DiceRollProvider();

    @Override
    protected void rollIt() {
        double value = diceRollProvider.getRandomDouble();

        if (value < 0.3) {
            result = DiceResult.SUCCESS;
        } else if (value < 0.4) {
            result = DiceResult.CRITICAL_HIT;
        } else if (value < 0.6) {
            result = DiceResult.FOCUS;
        } else {
            result = DiceResult.NOTHING;
        }
    }

    public static List<AttackDie> getDice(int number) {
        List<AttackDie> dice = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            dice.add(new AttackDie());
            dice.get(i).roll();
        }

        return dice;
    }
}
