package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.gameplay.meta.dice.AttackDie;
import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import com.nsxwing.common.gameplay.meta.dice.EvadeDie;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyEvadeEvent implements GameEvent {
	private PlayerAgent attacker;
	private Target defender;

	private List<AttackDie> attackDiceResults;
	private List<EvadeDie> evadeDiceResults;
}
