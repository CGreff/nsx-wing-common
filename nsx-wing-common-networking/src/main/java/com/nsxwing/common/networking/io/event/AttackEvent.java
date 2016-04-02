package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttackEvent implements GameEvent {
	private PlayerAgent attacker;
	private List<Target> targets;
}

