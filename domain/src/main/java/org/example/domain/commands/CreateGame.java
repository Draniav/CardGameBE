package org.example.domain.commands;

import java.util.Map;

public class CreateGame extends CrearJuegoCommand{
    private String gameId;
    private Map<String,String> players;


    public CreateGame(String juegoId, Map<String, String> jugadores, String gameId, Map<String, String> players) {
        super(juegoId, jugadores);
        this.gameId = gameId;
        this.players = players;
    }

    public String getGameId() {
        return gameId;
    }

    public Map<String, String> getPlayers() {
        return players;
    }
}
