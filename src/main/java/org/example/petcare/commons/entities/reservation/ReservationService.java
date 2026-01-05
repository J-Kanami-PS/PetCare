package org.example.petcare.commons.entities.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;
import org.example.petcare.commons.entities.pet.Pet;
import org.example.petcare.commons.entities.service.Service;

@Getter
@Setter
@Entity
@Table(name = "reservation_services")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_reservation_service")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class ReservationService extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_reservation", nullable = false)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_service", nullable = false)
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pet", nullable = false)
    private Pet pet;
}
