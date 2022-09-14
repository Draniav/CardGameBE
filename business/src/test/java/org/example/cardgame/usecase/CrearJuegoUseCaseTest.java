package org.example.cardgame.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.command.CrearJuegoCommand;
import org.example.cardgame.events.JuegoCreado;
import org.example.cardgame.events.JugadorAgregado;
import org.example.cardgame.gateway.ListaDeCartaService;
import org.example.cardgame.gateway.model.CartaMaestra;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashMap;
import java.util.function.Predicate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearJuegoUseCaseTest {

    @Mock
    private ListaDeCartaService listaDeCartaService;

    @InjectMocks
    private CrearJuegoUseCase useCase;

    @Test
    void crearJuego() {

        //arrange
        var command = new CrearJuegoCommand();
        command.setJuegoId("J-01");
        command.setJugadores(new HashMap<>());
        command.getJugadores().put("jugador-01", "Andres");
        command.getJugadores().put("jugador-02", "Martin");
        command.setJugadorPrincipalId("Id01");

        when(listaDeCartaService.obtenerCartasDeMarvel()).thenReturn(history());

        StepVerifier.create(useCase.apply(Mono.just(command)))

                .expectNextMatches(new Predicate<DomainEvent>() {
                    @Override
                    public boolean test(DomainEvent domainEvent) {
                        var event = (JuegoCreado) domainEvent;
                        return "J-01".equals(event.aggregateRootId()) && "Id01".equals(event.getJugadorPrincipal().value());
                    }
                })

                .expectNextMatches(domainEvent -> {
                    var event = (JugadorAgregado) domainEvent;
                    assert event.getMazo().value().cantidad().equals(2);
                    return event.getJuegoId().value().equals("jugador-01") && event.getAlias().equals("Andres");
                })

                .expectNextMatches(domainEvent -> {
                    var event = (JugadorAgregado) domainEvent;
                    assert event.getMazo().value().cantidad().equals(2);
                    return event.getJuegoId().value().equals("jugador-02") && event.getAlias().equals("Martin");
                })
                .expectComplete()
                .verify();
    }

    private Flux<CartaMaestra> history() {

        return Flux.just(

                new CartaMaestra("1", "CartaID1"),
                new CartaMaestra("2", "CartaID2"),
                new CartaMaestra("3", "CartaID3"),
                new CartaMaestra("10", "CartaID10"),
                new CartaMaestra("11", "CartaID11"),
                new CartaMaestra("12", "CartaID12"),
                new CartaMaestra("4", "CartaID4"),
                new CartaMaestra("5", "CartaID5"),
                new CartaMaestra("6", "CartaID6"),
                new CartaMaestra("7", "CartaID7"),
                new CartaMaestra("8", "CartaID8"),
                new CartaMaestra("9", "CartaID9")

        );
    }
}