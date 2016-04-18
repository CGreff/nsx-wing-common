package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.player.agent.PlayerAgent;

public class RangeFinderFactory {

	public RangeFinder build(PlayerAgent agent) {
		return new RangeFinder(agent);
	}
}
