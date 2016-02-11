package com.nsxwing.common.event;

import java.io.Serializable;

public interface GameEvent extends Serializable {

	default Class getEventType() {
		return this.getClass();
	}
}
