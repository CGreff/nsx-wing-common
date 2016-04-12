package com.nsxwing.common.state;

public class CombatStateFactory {

	public CombatState buildInitialCombatState(GameState gameState) {
		CombatState combatState = new CombatState();
		combatState.setChamp(gameState.getChamp());
		combatState.setScrub(gameState.getScrub());
		return combatState;
	}
}
