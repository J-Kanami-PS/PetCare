package org.example.petcare.commons.entities.reservation;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;
import org.example.petcare.commons.entities.enums.ReservationStateEnum;
import org.example.petcare.commons.entities.user.Carer;
import org.example.petcare.commons.entities.user.Owner;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "reservation")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_reservation")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Reservation extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_owner", nullable = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_carer", nullable = false)
    private Carer carer;

    @NotNull(message = "La fecha del servicio es obligatoria")
    @Column(name = "service_date", nullable = false)
    private LocalDateTime serviceDate;

    @NotNull(message = "El estado de la reserva es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReservationStateEnum state = ReservationStateEnum.PENDING;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    private Set<ReservationService> reservationServices = new HashSet<>();
}
