package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.state.GameState;

public interface GameEvent {

	default Class getEventType() {
		return this.getClass();
	}
}
