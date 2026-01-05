package org.example.petcare.commons.entities.enums;

import lombok.Getter;

@Getter
public enum ReservationStateEnum {
    PENDING("Pendiente"),
    ACCEPTED("Aceptada"),
    REJECTED("Rechazada"),
    FINISHED("Finalizada");

    private final String description;

    ReservationStateEnum(String description) {
        this.description = description;
    }
}
