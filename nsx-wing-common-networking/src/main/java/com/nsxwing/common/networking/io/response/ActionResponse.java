package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.gameplay.action.Action;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActionResponse extends GameResponse {
	Action action;
}
