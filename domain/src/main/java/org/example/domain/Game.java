package org.example.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.domain.values.State;
import org.example.domain.events.CreatedGame;
import org.example.domain.values.GameId;
import org.example.domain.events.AddedPlayer;
import org.example.domain.values.PlayerId;

import java.util.Map;

public class Game extends AggregateEvent<GameId> {
    protected Map<PlayerId, Player> players;
    protected Board board;
    protected Player winner;
    protected State state;

    public Game(GameId entityId, PlayersFactory factory) {
        super(entityId);
        appendChange(new CreatedGame(
                new State(State.gameStates.CREATED))).apply();
        factory.players().forEach(player -> appendChange(new AddedPlayer(
                player.identity(),
                player.alias()
        )).apply());
        subscribe(new GameEventChange(this));
    }

    private Game(GameId entityId){
        super(entityId);
    }
}
