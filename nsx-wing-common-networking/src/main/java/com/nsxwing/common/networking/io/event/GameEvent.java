package com.nsxwing.common.networking.io.event;

public interface GameEvent {

	default Class getEventType() {
		return this.getClass();
	}
}
