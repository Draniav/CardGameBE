package org.example.domain;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.values.Card;
import org.example.domain.values.PlayerId;
import org.example.domain.values.BoardId;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board extends Entity<BoardId> {
    private Map<PlayerId, Card> cards;
    private Integer time;

    public Board(BoardId entityId, Integer time) {
        super(entityId);
        this.cards = new HashMap<>();
        this.time = time;
    }

    //behaviors
    public void updateTime(Integer time) {
        this.time = time;
    }

    public void playCardOnBoard(PlayerId id, Card card) {
        this.cards.put(id, card);
    }

    public Set<Card> cards() {
        return new HashSet<>(cards.values());
    }


}
