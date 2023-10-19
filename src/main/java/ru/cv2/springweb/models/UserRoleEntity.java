package ru.cv2.springweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import ru.cv2.springweb.models.enums.Role;

import java.util.UUID;
@Entity
public class UserRoleEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    private Role role;

    private UserRoleEntity(UUID uuid, Role role) {
        this.uuid = uuid;
        this.role = role;
    }

    public UserRoleEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
