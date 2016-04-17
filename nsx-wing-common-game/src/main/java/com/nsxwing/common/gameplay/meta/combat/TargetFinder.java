package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.player.agent.PlayerAgent;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TargetFinder {
	public List<Target> findTargets(PlayerAgent agent, RangeFinder rangeFinder, List<PlayerAgent> playerAgents) {
		FiringArc firingArc = agent.determineFiringArc();

		return playerAgents.stream()
				.filter(playerAgent -> agent.getOwner() != playerAgent.getOwner())
				.filter(playerAgent -> firingArc.isTargetable(playerAgent.getPosition().getCenter()) && rangeFinder.getRangeToTarget(playerAgent) <= 3)
				.map(playerAgent -> new Target(playerAgent, rangeFinder.getRangeToTarget(playerAgent), false))
				.collect(toList());
	}
}
