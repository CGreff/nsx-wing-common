package com.nsxwing.common.gameplay.meta.dice;

import lombok.Getter;

/**
 * Interface that describes rolling of dice; results left to implementations.
 */
public abstract class Die {
    boolean hasBeenRolled = false;
    boolean hasBeenRerolled = false;

	@Getter
	DiceResult result = DiceResult.NOTHING;

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

    protected abstract void rollIt();
}