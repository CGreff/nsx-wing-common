package com.nsxwing.common.player;

import com.esotericsoftware.kryonet.Connection;
import com.nsxwing.common.player.PlayerIdentifier;
import com.nsxwing.common.player.agent.PlayerAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	private PlayerIdentifier identifier;
	private Connection connection;
	private List<PlayerAgent> playerAgents;
}
