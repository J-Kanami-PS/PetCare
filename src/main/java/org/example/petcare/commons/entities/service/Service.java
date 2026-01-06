package org.example.petcare.commons.entities.service;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;
import org.example.petcare.commons.entities.user.Carer;
import org.example.petcare.commons.entities.reservation.ReservationService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "services")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_service")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Service extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_carer", nullable = false)
    private Carer carer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_service_type", nullable = false)
    private ServiceType serviceType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private Set<ReservationService> reservationServices = new HashSet<>();
}
