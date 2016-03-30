package com.nsxwing.common.state;

import com.nsxwing.common.gameplay.meta.dice.AttackDie;
import com.nsxwing.common.gameplay.meta.dice.EvadeDie;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombatState {
	private PlayerAgent attacker;
	private PlayerAgent defender;

	private List<AttackDie> attackDice;
	private List<EvadeDie> evadeDice;
}
