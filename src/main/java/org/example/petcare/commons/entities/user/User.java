package org.example.petcare.commons.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_user")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class User extends AbstractEntity {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 60, message = "El nombre no puede exceder 60 caracteres")
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 60, message = "El apellido no puede exceder 60 caracteres")
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un email válido")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "\\d{10,15}", message = "El teléfono debe tener entre 10 y 15 dígitos")
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "profile_photo", columnDefinition = "TEXT")
    private String profilePhoto;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
