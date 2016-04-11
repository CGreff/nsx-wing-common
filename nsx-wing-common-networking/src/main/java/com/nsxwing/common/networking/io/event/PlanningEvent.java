package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.state.GameState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanningEvent implements GameplayEvent {
	private GameState gameState;
}

