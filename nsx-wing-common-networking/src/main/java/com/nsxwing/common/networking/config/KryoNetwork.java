package com.nsxwing.common.networking.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.nsxwing.common.networking.io.response.ActionResponse;
import com.nsxwing.common.networking.io.response.AttackResponse;
import com.nsxwing.common.networking.io.response.EndAttackResponse;
import com.nsxwing.common.networking.io.response.ModifyAttackResponse;
import com.nsxwing.common.networking.io.response.ModifyDefenseResponse;
import com.nsxwing.common.networking.io.response.PlanningResponse;
import com.nsxwing.common.networking.io.response.PostCombatResponse;
import com.nsxwing.common.networking.io.response.PreCombatResponse;
import com.nsxwing.common.networking.io.event.ActionEvent;
import com.nsxwing.common.networking.io.event.AttackEvent;
import com.nsxwing.common.networking.io.event.EndAttackEvent;
import com.nsxwing.common.networking.io.event.GameEndEvent;
import com.nsxwing.common.networking.io.event.GameStartEvent;
import com.nsxwing.common.networking.io.event.ModifyAttackEvent;
import com.nsxwing.common.networking.io.event.ModifyDefenseEvent;
import com.nsxwing.common.networking.io.event.PlanningEvent;
import com.nsxwing.common.networking.io.event.PostCombatEvent;
import com.nsxwing.common.networking.io.event.PreCombatEvent;

public class KryoNetwork {

	static public final int PORT = 54555;

	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(ActionEvent.class);
		kryo.register(ActionResponse.class);
		kryo.register(AttackEvent.class);
		kryo.register(AttackResponse.class);
		kryo.register(EndAttackEvent.class);
		kryo.register(EndAttackResponse.class);
		kryo.register(ModifyAttackEvent.class);
		kryo.register(ModifyAttackResponse.class);
		kryo.register(ModifyDefenseEvent.class);
		kryo.register(ModifyDefenseResponse.class);
		kryo.register(PlanningEvent.class);
		kryo.register(PlanningResponse.class);
		kryo.register(PostCombatEvent.class);
		kryo.register(PostCombatResponse.class);
		kryo.register(PreCombatEvent.class);
		kryo.register(PreCombatResponse.class);
		kryo.register(GameStartEvent.class);
		kryo.register(GameEndEvent.class);
	}

}
