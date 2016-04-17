package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.state.GameState;

public class Void implements Action {
	@Override
	public GameState execute(GameState gameState) {
		return gameState;
	}
}
