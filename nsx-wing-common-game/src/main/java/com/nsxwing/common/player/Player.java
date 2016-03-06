package com.nsxwing.common.player;

import com.esotericsoftware.kryonet.Connection;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.Getter;

import java.util.List;

@Getter
public class Player {

	private PlayerIdentifier identifier;
	private Connection connection;
	private List<PlayerAgent> playerAgents;

	public Player(PlayerIdentifier identifier, Connection connection, List<PlayerAgent> playerAgents) {
		this.identifier = identifier;
		this.connection = connection;
		this.playerAgents = playerAgents;
	}
}
