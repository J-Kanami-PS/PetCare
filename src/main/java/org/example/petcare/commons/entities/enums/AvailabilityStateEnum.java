package org.example.petcare.commons.entities.enums;

import lombok.Getter;

@Getter
public enum AvailabilityStateEnum {
    AVAILABLE("Disponible"),
    NOT_AVAILABLE("No disponible"),
    BUSY("Ocupado");

    private final String description;

    AvailabilityStateEnum(String description) {
        this.description = description;
    }
}
