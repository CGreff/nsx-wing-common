package com.nsxwing.common.player;

import com.nsxwing.common.exception.PlayerAlreadySetException;
import com.nsxwing.common.exception.PlayerNotSetException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static com.nsxwing.common.player.PlayerName.CHAMP;
import static com.nsxwing.common.player.PlayerName.SCRUB;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerIdentifierTest {

	@Before
	public void setUp() throws Exception {
		Field field = PlayerIdentifier.class.getDeclaredField("PLAYER_ID");
		field.setAccessible(true);
		field.set(null, null);
	}

	@Test(expected = PlayerNotSetException.class)
	public void shouldThrowExceptionWhenNoPlayerIdSet() {
		PlayerIdentifier.getPlayerId();
	}

	@Test
	public void shouldBeAbleToSetAPlayerId() {
		PlayerIdentifier.setPlayerId(CHAMP);
	}

	@Test(expected = PlayerAlreadySetException.class)
	public void shouldNotBeAbleToSetASecondPlayerId() {
		//This is fine.
		PlayerIdentifier.setPlayerId(CHAMP);

		//This is a no-no.
		PlayerIdentifier.setPlayerId(SCRUB);
	}

	@Test
	public void shouldBeAbleToGetAPlayerId() {
		PlayerIdentifier.setPlayerId(CHAMP);

		assertThat(PlayerIdentifier.getPlayerId(), is(CHAMP));
	}
}