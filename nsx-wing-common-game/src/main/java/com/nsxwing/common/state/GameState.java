package com.nsxwing.common.state;

import com.nsxwing.common.gameplay.meta.combat.RangeFinder;
import com.nsxwing.common.gameplay.meta.combat.RangeFinderFactory;
import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.gameplay.meta.combat.TargetFinder;
import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.Maneuver;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.nsxwing.common.gameplay.meta.dice.DamageDeterminant.determineDamage;
import static com.nsxwing.common.player.PlayerIdentifier.CHAMP;
import static com.nsxwing.common.player.PlayerIdentifier.SCRUB;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class GameState extends PlayerHandlingState {
	protected static int MAX_TURNS = 100;

	private List<PlayerAgent> playerAgents;
	private Map<String, Maneuver> plannedManeuvers;
	private int turnNumber;
	private TargetFinder targetFinder;
	private RangeFinderFactory rangeFinderFactory;

	public GameState(Player champ, Player scrub, List<PlayerAgent> playerAgents, Map<String, Maneuver> plannedManeuvers, int turnNumber) {
		this.champ = champ;
		this.scrub = scrub;
		this.playerAgents = playerAgents;
		this.targetFinder = new TargetFinder();
		this.rangeFinderFactory = new RangeFinderFactory();
		this.plannedManeuvers = plannedManeuvers;
		this.turnNumber = turnNumber;
	}

	public boolean isGameComplete() {
		return turnNumber >= MAX_TURNS ||
				playerAgents.stream().noneMatch(this::isChampAgent) ||
				playerAgents.stream().noneMatch(this::isScrubAgent);
	}

	private boolean isChampAgent(PlayerAgent playerAgent) {
		return playerAgent.getOwner() == CHAMP;
	}

	private boolean isScrubAgent(PlayerAgent playerAgent) {
		return playerAgent.getOwner() == SCRUB;
	}

	public void maneuverAgent(String agentIdentifier, Maneuver maneuver) {
		playerAgents.stream()
				.filter((matchesPlayerAgent(agentIdentifier)))
				.forEach(maneuverAgentConsumer(maneuver));
	}

	public List<Target> findTargetsFor(PlayerAgent agent) {
		return targetFinder.findTargets(agent, rangeFinderFactory.build(agent), playerAgents);
	}

	private Consumer<PlayerAgent> maneuverAgentConsumer(Maneuver maneuver) {
		return playerAgent -> playerAgent.setPosition(maneuver.move(playerAgent.getPosition()));
	}

	public void applyCombat(CombatState combatState) {
		determineDamage(combatState.getAttackDice(), combatState.getEvadeDice())
				.stream()
				.forEach(diceResult -> { inflictDamage(combatState.getDefender(), diceResult);});
	}

	private void inflictDamage(Target target, DiceResult result) {
		playerAgents.stream()
				.filter(matchesPlayerAgent(target.getTargetAgent().getAgentId()))
				.forEach(inflictDamageConsumer(result));
	}

	private Predicate<PlayerAgent> matchesPlayerAgent(String agentId) {
		return playerAgent -> playerAgent.getAgentId().equals(agentId);
	}

	private Consumer<PlayerAgent> inflictDamageConsumer(DiceResult result) {
		return playerAgent -> playerAgent.sufferDamage(result == DiceResult.CRITICAL_HIT);
	}
}
