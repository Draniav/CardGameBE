package org.example.business.gateway;

import org.example.business.gateway.model.MasterCard;
import reactor.core.publisher.Flux;

public interface ConsultMasterCardService {

    Flux<MasterCard> getAllMasterCards();

}
