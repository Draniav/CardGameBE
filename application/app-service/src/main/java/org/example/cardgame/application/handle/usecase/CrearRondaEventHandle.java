package org.example.cardgame.application.handle.usecase;



import org.example.cardgame.application.handle.IntegrationHandle;
import org.example.cardgame.command.CrearRondaCommand;
import org.example.cardgame.events.RondaTerminada;
import org.example.cardgame.usecase.CrearRondaUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import reactor.core.publisher.Mono;




@Configuration
public class CrearRondaEventHandle {

    private final CrearRondaUseCase usecase;

    private final IntegrationHandle handle;

    public CrearRondaEventHandle(CrearRondaUseCase usecase, IntegrationHandle handle) {
        this.usecase = usecase;
        this.handle = handle;
    }

    @EventListener
    public void handleCrearRonda(CrearRondaCommand event) {
        handle.apply(usecase.apply(Mono.just(event))).block();
    }


}