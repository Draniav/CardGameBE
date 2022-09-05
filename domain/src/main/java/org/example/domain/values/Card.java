package org.example.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Card implements ValueObject<Card.Props> {
    private final Integer power;
    private final String masterCardId;
    private final Boolean isItAble;

    public Card(Integer power, String masterCardId, Boolean isItAble) {
        this.power = Objects.requireNonNull(power);
        this.masterCardId = Objects.requireNonNull(masterCardId);
        this.isItAble = Objects.requireNonNull(isItAble);

        if(this.power <= 0){
            throw new IllegalArgumentException("card´s power must be greater than 0");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer power() {
                return power;
            }

            @Override
            public String masterCardId() {
                return masterCardId;
            }

            @Override
            public Boolean isItAble() {
                return isItAble;
            }
        };
    }

    public interface Props {
         Integer power();
         String masterCardId();
         Boolean isItAble();
    }
}
