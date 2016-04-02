package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyDefenseEvent implements GameEvent {
	private PlayerAgent attacker;
	private PlayerAgent defender;

	private List<DiceResult> attackDiceResults;
	private List<DiceResult> evadeDiceResults;
}
