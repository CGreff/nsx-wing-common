package com.nsxwing.common.state;

import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.gameplay.meta.dice.AttackDie;
import com.nsxwing.common.gameplay.meta.dice.EvadeDie;
import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CombatState extends PlayerHandlingState {
	private PlayerAgent attacker;
	private Target defender;

	private List<AttackDie> attackDice;
	private List<EvadeDie> evadeDice;

	public CombatState(Player champ, Player scrub, PlayerAgent attacker, Target defender, List<AttackDie> attackDice, List<EvadeDie> evadeDice) {
		this.champ = champ;
		this.scrub = scrub;
		this.attacker = attacker;
		this.defender = defender;
		this.attackDice = attackDice;
		this.evadeDice = evadeDice;
	}
}
