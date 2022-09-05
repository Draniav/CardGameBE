package org.example.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class State implements ValueObject<State.gameStates> {
    private final gameStates gameStates;

    public State(gameStates gameStates) {
        this.gameStates = Objects.requireNonNull(gameStates);
    }

    @Override
    public gameStates value() {
        return gameStates;
    }

    public enum gameStates {
        CREATED, INITIALIZED,FINISHED
    }
}
