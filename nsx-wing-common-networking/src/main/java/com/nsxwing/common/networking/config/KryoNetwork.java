package com.nsxwing.common.networking.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.nsxwing.common.event.server.ActionEvent;
import com.nsxwing.common.event.server.AttackEvent;
import com.nsxwing.common.event.server.EndAttackEvent;
import com.nsxwing.common.event.server.ModifyAttackEvent;
import com.nsxwing.common.event.server.ModifyDefenseEvent;
import com.nsxwing.common.event.server.PlanningEvent;
import com.nsxwing.common.event.server.PostCombatEvent;
import com.nsxwing.common.event.server.PreCombatEvent;

public class KryoNetwork {

	static public final int port = 54555;

	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(ActionEvent.class);
		kryo.register(AttackEvent.class);
		kryo.register(EndAttackEvent.class);
		kryo.register(ModifyAttackEvent.class);
		kryo.register(ModifyDefenseEvent.class);
		kryo.register(PlanningEvent.class);
		kryo.register(PostCombatEvent.class);
		kryo.register(PreCombatEvent.class);
	}

}
