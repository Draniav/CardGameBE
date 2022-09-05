package org.example.domain.values;

import co.com.sofka.domain.generic.Identity;

public class GameId extends Identity {
    private GameId(String gameId) {
        super(gameId);
    }

    public static GameId of(String gameId) {
        return new GameId(gameId);
    }
}
