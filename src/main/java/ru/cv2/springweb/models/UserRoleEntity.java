package ru.cv2.springweb.models;

import jakarta.persistence.Entity;
import ru.cv2.springweb.models.abstracts.BaseEntity;
import ru.cv2.springweb.models.enums.Role;

import java.util.UUID;
@Entity
public class UserRoleEntity extends BaseEntity {

    private Role role;

    private UserRoleEntity(UUID uuid, Role role) {
        this.role = role;
    }

    public UserRoleEntity() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
