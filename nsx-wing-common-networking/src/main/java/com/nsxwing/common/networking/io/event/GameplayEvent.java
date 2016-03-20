package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.state.GameState;

public interface GameplayEvent extends GameEvent {

	GameState getGameState();
}
