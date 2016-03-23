package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.position.Maneuver;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class PlanningResponse extends GameResponse {
	private Map<String, Maneuver> agentManeuvers;
}
