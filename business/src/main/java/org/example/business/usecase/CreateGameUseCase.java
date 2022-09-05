package org.example.business.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.business.gateway.ConsultMasterCardService;
import org.example.domain.Game;
import org.example.domain.PlayersFactory;
import org.example.domain.commands.CreateGame;
import org.example.domain.values.GameId;
import org.example.domain.values.PlayerId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;


public class CreateGameUseCase implements Function<Mono<CreateGame>, Flux<DomainEvent>> {

    private final ConsultMasterCardService service;

    public CreateGameUseCase(ConsultMasterCardService service) {
        this.service = service;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CreateGame> CreateGame) {
        return CreateGame.flatMapMany((command) -> {
            var factory = new PlayersFactory();

            command.getPlayers().forEach((id, nickName) ->
                    factory.addPlayer(PlayerId.of(id), nickName) //, generarMazo())
            );
            var game = new Game(GameId.of(command.getGameId()), factory);
            return Flux.fromIterable(game.getUncommittedChanges());
        });
    }


}
