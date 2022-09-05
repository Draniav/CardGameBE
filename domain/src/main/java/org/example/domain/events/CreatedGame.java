package org.example.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.values.State;

public class CreatedGame extends DomainEvent {
    private final State state;

    public CreatedGame(State state) {
       // super("domain.CreatedGame");
        super("org.example.domain.CreatedGame");
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
