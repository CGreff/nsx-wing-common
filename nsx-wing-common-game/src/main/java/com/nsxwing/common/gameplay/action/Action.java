package com.nsxwing.common.gameplay.action;

import com.nsxwing.common.state.GameState;

public interface Action {
	GameState execute(GameState gameState);
}
