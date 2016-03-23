package com.nsxwing.common.networking.io.response;

import com.nsxwing.common.gameplay.action.Action;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ActionResponse extends GameResponse {
	Action action;
}
