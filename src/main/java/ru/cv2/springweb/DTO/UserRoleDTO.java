package ru.cv2.springweb.DTO;

import ru.cv2.springweb.models.enums.Role;

import java.util.UUID;
public class UserRoleDTO {

    private UUID uuid;
    private Role role;

    private UserRoleDTO(UUID uuid, Role role) {
        this.uuid = uuid;
        this.role = role;
    }

    public UserRoleDTO() {
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
