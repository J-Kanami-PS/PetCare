package org.example.petcare.commons.entities.service;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "service_types")
@AttributeOverride(name = "id", column = @Column(name = "id_service_type"))
public class ServiceType extends BaseEntity {
    @NotBlank(message = "El nombre del tipo de servicio es obligatorio")
    @Size(max = 100, message = "El nombre del tipo de servicio no puede exceder 100 caracteres")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "serviceType", fetch = FetchType.LAZY)
    private Set<Service> services = new HashSet<>();
}
