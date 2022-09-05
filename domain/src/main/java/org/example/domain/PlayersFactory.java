package org.example.domain;

import org.example.domain.values.PlayerId;

import java.util.HashSet;
import java.util.Set;

public class PlayersFactory {
    private final Set<Player> players;

    public PlayersFactory() {
        this.players = new HashSet<>();
    }

    public void addPlayer(PlayerId id, String nickName){//, Mazo mazo){
       this.players.add(new Player(id, nickName));//, mazo)) ;
    }

    protected Set<Player> players() {
        return players;
    }

}
