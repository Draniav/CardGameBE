package org.example.domain;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.values.PlayerId;

public class Player extends Entity<PlayerId> {
    private final String alias;

    public Player(PlayerId id, String nickName) {
        super(id);
        this.alias = nickName;
    }



    public String alias() {
        return alias;
    }
}
