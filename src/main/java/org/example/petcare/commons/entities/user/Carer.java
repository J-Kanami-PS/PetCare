package org.example.petcare.commons.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;
import org.example.petcare.commons.entities.enums.AvailabilityStateEnum;

@Getter
@Setter
@Entity
@Table(name = "carers")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_carer")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Carer extends AbstractEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false, unique = true)
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private AvailabilityStateEnum status = AvailabilityStateEnum.AVAILABLE;

    @Column(name = "max_pets_allowed", nullable = false)
    private Integer maxPetsAllowed = 1;
}
