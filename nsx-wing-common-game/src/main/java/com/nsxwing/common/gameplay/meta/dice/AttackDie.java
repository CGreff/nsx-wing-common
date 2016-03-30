package com.nsxwing.common.gameplay.meta.dice;

import com.nsxwing.common.gameplay.meta.dice.DiceRollProvider.RandomProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AttackDie extends Die {

	private RandomProvider diceRollProvider = DiceRollProvider::getRandomDouble;

    @Override
    protected void rollIt() {
        double val = diceRollProvider.getRandomDouble();

        if (val < 0.3) {
            result = DiceResult.SUCCESS;
        } else if (val < 0.4) {
            result = DiceResult.CRITICAL_HIT;
        } else if (val < 0.6) {
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
