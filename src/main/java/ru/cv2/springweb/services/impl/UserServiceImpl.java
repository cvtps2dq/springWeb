package ru.cv2.springweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.UserDTO;
import ru.cv2.springweb.mappers.UserEntityMapper;
import ru.cv2.springweb.mappers.UserRoleEntityMapper;
import ru.cv2.springweb.repositories.UserRepository;
import ru.cv2.springweb.services.UserService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final UserRoleEntityMapper roleMapper;

    private final UserEntityMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRoleEntityMapper roleMapper, UserEntityMapper userMapper) {
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public UserDTO getUserById(UUID id) {
        if (userRepository.findById(id).isPresent())
            return userMapper.toDTO(userRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No model found with this UUID!");
    }
    @Override
    public UserDTO getUserByName(String name) {

        return userMapper.toDTO(userRepository.findUserByUsername(name));
    }
    @Override
    public UserDTO saveUser(UserDTO user) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }
    @Override
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

                    return  userMapper.toDTO(userRepository.save(user));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }
    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}