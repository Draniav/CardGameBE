package org.example.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.values.PlayerId;

public class AddedPlayer extends DomainEvent {
    private final PlayerId playerId;
    private final String nickName;

    public AddedPlayer(PlayerId playerId, String nickName) {
        //super("domain.AddedPlayer");
        super("org.example.domain.AddedPlayer");
        this.playerId = playerId;
        this.nickName = nickName;
    }


    public String getNickName() {
        return nickName;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }
}
