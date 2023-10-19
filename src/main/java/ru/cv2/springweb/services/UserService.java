package ru.cv2.springweb.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.UserDTO;
import ru.cv2.springweb.mappers.UserEntityMapper;
import ru.cv2.springweb.mappers.UserRoleEntityMapper;
import ru.cv2.springweb.repositories.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleEntityMapper roleMapper;

    private final UserEntityMapper userMapper;

    public UserService(UserRepository userRepository, UserRoleEntityMapper roleMapper, UserEntityMapper userMapper) {
        this.userRepository = userRepository;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(UUID id) {
        if (userRepository.findById(id).isPresent())
            return userMapper.toDTO(userRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No model found with this UUID!");
    }

    public UserDTO getUserByName(UserDTO user) {

        return userMapper.toDTO(userRepository.findUserByUsername(user.getUsername()));
    }

    public UserDTO saveUser(UserDTO user) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }

    public UserDTO editUser(UserDTO updatedUser, UUID id) {
        return userRepository.findById(id)
                .map(user -> {
                    if(updatedUser.getUsername() != null) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if(updatedUser.getFirstName() != null) {
                        user.setFirstName(updatedUser.getFirstName());
                    }
                    if(updatedUser.getLastName() != null) {
                        user.setLastName(updatedUser.getLastName());
                    }
                    if(updatedUser.getActive() != null) {
                        user.setActive(updatedUser.getActive());
                    }
                    if(updatedUser.getRole() != null) {
                        user.setRole(roleMapper.toEntity(updatedUser.getRole()));
                    }
                    if(updatedUser.getImageUrl() != null) {
                        user.setImageUrl(updatedUser.getImageUrl());
                    }
                    if(updatedUser.getCreated() != null) {
                        user.setCreated(updatedUser.getCreated());
                    }
                    if(updatedUser.getModified() != null) {
                        user.setModified(updatedUser.getModified());
                    }

                    return  userMapper.toDTO(userRepository.save(user));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}