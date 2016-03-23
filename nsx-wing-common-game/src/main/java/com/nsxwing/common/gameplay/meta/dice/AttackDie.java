package com.nsxwing.common.gameplay.meta.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementation of the Dice interface for Attacking.
 */
//TODO: Extract common stuff with EvadeDie. Also Test drive.
class AttackDie implements Die {

    boolean hasBeenRolled = false;
    boolean hasBeenRerolled = false;
    DiceResult result = DiceResult.NOTHING;

    @Override
    public void roll() {
        if (hasNotBeenRolled()) {
            hasBeenRolled = true;
            rollIt();
        } else if (hasNotBeenRerolled()) {
            hasBeenRerolled = true;
            rollIt();
        }
    }

    private boolean hasNotBeenRerolled() {
        return !hasBeenRerolled;
    }

    private boolean hasNotBeenRolled() {
        return !(hasBeenRerolled || hasBeenRolled);
    }

    private void rollIt() {
        Random r = new Random();
        double val = r.nextDouble() * 0.8;

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

    static List<AttackDie> getDice(int number) {
        List<AttackDie> dice = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            dice.add(new AttackDie());
            dice.get(i).roll();
        }

        return dice;
    }
}
