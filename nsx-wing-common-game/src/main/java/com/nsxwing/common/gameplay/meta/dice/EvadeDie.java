package com.nsxwing.common.gameplay.meta.dice;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class EvadeDie extends Die {
	private DiceRollProvider diceRollProvider = new DiceRollProvider();

    protected void rollIt() {
        double value = diceRollProvider.getRandomDouble();

        if (value < 0.3) {
            result = DiceResult.SUCCESS;
        } else if (value < 0.5) {
            result = DiceResult.FOCUS;
        } else {
            result = DiceResult.NOTHING;
        }
    }

    public static List<EvadeDie> getDice(int number) {
        List<EvadeDie> dice = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            dice.add(new EvadeDie());
            dice.get(i).roll();
        }

        return dice;
    }
}
