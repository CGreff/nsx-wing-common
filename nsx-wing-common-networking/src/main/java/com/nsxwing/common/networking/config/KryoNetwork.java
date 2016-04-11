package com.nsxwing.common.networking.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.nsxwing.common.component.pilot.Pilot;
import com.nsxwing.common.gameplay.action.Action;
import com.nsxwing.common.gameplay.action.Focus;
import com.nsxwing.common.gameplay.meta.combat.Target;
import com.nsxwing.common.gameplay.meta.dice.AttackDie;
import com.nsxwing.common.gameplay.meta.dice.DiceResult;
import com.nsxwing.common.gameplay.meta.dice.DiceRollProvider;
import com.nsxwing.common.gameplay.meta.dice.EvadeDie;
import com.nsxwing.common.gameplay.meta.modifiers.DiceFocuser;
import com.nsxwing.common.gameplay.meta.modifiers.DiceModifer;
import com.nsxwing.common.gameplay.meta.modifiers.NoOpModifier;
import com.nsxwing.common.networking.io.event.ActionEvent;
import com.nsxwing.common.networking.io.event.AttackEvent;
import com.nsxwing.common.networking.io.event.ConnectionEvent;
import com.nsxwing.common.networking.io.event.EndAttackEvent;
import com.nsxwing.common.networking.io.event.GameEndEvent;
import com.nsxwing.common.networking.io.event.ModifyAttackEvent;
import com.nsxwing.common.networking.io.event.ModifyEvadeEvent;
import com.nsxwing.common.networking.io.event.PlanningEvent;
import com.nsxwing.common.networking.io.event.PostCombatEvent;
import com.nsxwing.common.networking.io.event.PreCombatEvent;
import com.nsxwing.common.networking.io.response.ActionResponse;
import com.nsxwing.common.networking.io.response.AttackResponse;
import com.nsxwing.common.networking.io.response.ConnectionResponse;
import com.nsxwing.common.networking.io.response.EndAttackResponse;
import com.nsxwing.common.networking.io.response.ModifyAttackResponse;
import com.nsxwing.common.networking.io.response.ModifyEvadeResponse;
import com.nsxwing.common.networking.io.response.PlanningResponse;
import com.nsxwing.common.networking.io.response.PostCombatResponse;
import com.nsxwing.common.networking.io.response.PreCombatResponse;
import com.nsxwing.common.player.Player;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import com.nsxwing.common.position.Direction;
import com.nsxwing.common.position.Forward;
import com.nsxwing.common.position.Maneuver;
import com.nsxwing.common.position.ManeuverDifficulty;
import com.nsxwing.common.position.descriptor.Coordinate;
import com.nsxwing.common.position.descriptor.Position;
import com.nsxwing.common.state.GameState;
import de.javakaffee.kryoserializers.ArraysAsListSerializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KryoNetwork {

	static public final int PORT = 54555;

	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());
		kryo.register(List.class);
		kryo.register(ArrayList.class);
		kryo.register(Map.class);
		kryo.register(Integer.class);
		kryo.register(HashMap.class);

		kryo.register(GameState.class);
		kryo.register(PlayerIdentifier.class);
		kryo.register(PlayerAgent.class);
		kryo.register(Player.class);
		kryo.register(Target.class);
		kryo.register(Pilot.class);
		kryo.register(Action.class);
		kryo.register(Focus.class);

		kryo.register(DiceModifer.class);
		kryo.register(DiceFocuser.class);
		kryo.register(NoOpModifier.class);
		kryo.register(DiceResult.class);
		kryo.register(AttackDie.class);
		kryo.register(EvadeDie.class);
		kryo.register(DiceRollProvider.class);

		kryo.register(ActionEvent.class);
		kryo.register(ActionResponse.class);
		kryo.register(AttackEvent.class);
		kryo.register(AttackResponse.class);
		kryo.register(EndAttackEvent.class);
		kryo.register(EndAttackResponse.class);
		kryo.register(ModifyAttackEvent.class);
		kryo.register(ModifyAttackResponse.class);
		kryo.register(ModifyEvadeEvent.class);
		kryo.register(ModifyEvadeResponse.class);
		kryo.register(PlanningEvent.class);
		kryo.register(PlanningResponse.class);
		kryo.register(PostCombatEvent.class);
		kryo.register(PostCombatResponse.class);
		kryo.register(PreCombatEvent.class);
		kryo.register(PreCombatResponse.class);
		kryo.register(GameEndEvent.class);
		kryo.register(ConnectionEvent.class);
		kryo.register(ConnectionResponse.class);

		kryo.register(Position.class);
		kryo.register(Coordinate.class);
		kryo.register(Maneuver.class);
		kryo.register(ManeuverDifficulty.class);
		kryo.register(Direction.class);
		kryo.register(Forward.class);
	}


}
