package ru.cv2.springweb.services;

import ru.cv2.springweb.DTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getUserById(UUID id);

    UserDTO getUserByName(String name);

    UserDTO saveUser(UserDTO brand);
    UserDTO editUser(UserDTO updatedUserEntity, UUID id);
    void deleteUser(UUID id);

}
