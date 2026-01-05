package org.example.petcare.commons.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.petcare.commons.entities.base.AbstractEntity;

@Getter
@Setter
@Entity
@Table(name = "owners")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_owner")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at"))
})
public class Owner extends AbstractEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false, unique = true)
    private User user;
}
