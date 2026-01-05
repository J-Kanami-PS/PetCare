package org.example.petcare.commons.entities.pet;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;
import org.example.petcare.commons.entities.enums.PetSizeEnum;
import org.example.petcare.commons.entities.user.Owner;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pets")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_pet")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Pet extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_owner", nullable = false)
    private Owner owner;

    @NotBlank
    @Size(max = 60)
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "type_pet", nullable = false, length = 50)
    private String typePet;

    @Size(max = 60)
    @Column(name = "breed", length = 60)
    private String breed;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "size", nullable = false, length = 20)
    private PetSizeEnum size;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "photo", columnDefinition = "TEXT")
    private String photo;
}
