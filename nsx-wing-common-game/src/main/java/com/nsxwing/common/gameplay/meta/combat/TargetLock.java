package com.nsxwing.common.gameplay.meta.combat;

import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetLock {
	private PlayerAgent target;
}
