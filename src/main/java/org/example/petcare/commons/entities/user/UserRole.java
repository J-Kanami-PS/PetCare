package org.example.petcare.commons.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;

@Getter
@Setter
@Entity
@Table(name = "user_roles")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_user_role")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class UserRole extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_role", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;
}
