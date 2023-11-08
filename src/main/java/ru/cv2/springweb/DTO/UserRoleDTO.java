package ru.cv2.springweb.DTO;

import ru.cv2.springweb.models.enums.Role;

import java.util.UUID;
public class UserRoleDTO {

    private Role role;
    private UUID id;

    private UserRoleDTO(UUID id, Role role) {
        this.role = role;
        this.id = id;
    }

    public UserRoleDTO() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
