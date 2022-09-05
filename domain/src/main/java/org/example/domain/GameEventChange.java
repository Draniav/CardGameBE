package org.example.domain;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.events.CreatedGame;
import org.example.domain.events.AddedPlayer;

import java.util.HashMap;

public class GameEventChange extends EventChange {
    public GameEventChange(Game game) {
        apply((CreatedGame event) -> {
            game.state = event.getState();
            game.players = new HashMap<>();
            game.board = null;
        });

        apply((AddedPlayer event) -> {
            game.players.put(event.getPlayerId(),
                    new Player(event.getPlayerId(), event.getNickName())
            );
        });
    }
}
