package ru.cv2.springweb.services;

import ru.cv2.springweb.DTO.UserRoleDTO;

import java.util.List;
import java.util.UUID;

public interface UserRoleService {
    List<UserRoleDTO> getAll();
    UserRoleDTO getRoleById(UUID id);
    UserRoleDTO saveRole(UserRoleDTO brand);
    UserRoleDTO updateUserRole(UUID id, UserRoleDTO userRoleDto);
    void deleteRole(UUID id);

}
