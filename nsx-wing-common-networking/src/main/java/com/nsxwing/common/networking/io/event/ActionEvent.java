package com.nsxwing.common.networking.io.event;

import com.nsxwing.common.state.GameState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionEvent implements GameplayEvent {
	private GameState gameState;
}
