package org.example.petcare.commons.entities.enums;

import lombok.Getter;

@Getter
public enum PetSizeEnum {
    SMALL("Pequeño"),
    MEDIUM("Mediano"),
    LARGE("Grande");

    private final String description;

    PetSizeEnum(String description) {
        this.description = description;
    }
}
