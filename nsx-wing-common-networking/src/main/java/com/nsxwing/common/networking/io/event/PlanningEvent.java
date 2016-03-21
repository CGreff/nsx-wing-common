package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.state.GameState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanningEvent implements GameplayEvent {
	private GameState gameState;
}

