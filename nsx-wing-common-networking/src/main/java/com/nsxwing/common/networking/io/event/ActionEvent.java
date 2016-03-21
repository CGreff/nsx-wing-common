package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.state.GameState;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActionEvent implements GameplayEvent {
	private GameState gameState;
}
