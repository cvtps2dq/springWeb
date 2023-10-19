package ru.cv2.springweb.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.UserRoleDTO;
import ru.cv2.springweb.mappers.UserEntityMapper;
import ru.cv2.springweb.mappers.UserRoleEntityMapper;
import ru.cv2.springweb.models.UserRoleEntity;
import ru.cv2.springweb.models.enums.Role;
import ru.cv2.springweb.repositories.UserRoleRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleService {
    private final UserRoleRepository roleRepository;
    private final UserRoleEntityMapper roleMapper;
    private final UserEntityMapper userMapper;

    public UserRoleService(UserRoleRepository roleRepository, UserRoleEntityMapper roleMapper, UserEntityMapper userMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }

    public List<UserRoleDTO> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserRoleDTO getRoleById(UUID id) {
        if (roleRepository.findById(id).isPresent())
            return roleMapper.toDTO(roleRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No role found with this UUID!");
    }

    public UserRoleDTO saveRole(UserRoleDTO role) {
        return roleMapper.toDTO(roleRepository.save(roleMapper.toEntity(role)));
    }

    public UserRoleDTO updateUserRole(UUID id, UserRoleDTO userRoleDto) {
        UserRoleEntity userRole = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("UserRole not found"));

        // Обновление поля роли
        userRole.setRole(userRoleDto.getRole());

        UserRoleEntity updatedUserRole = roleRepository.save(userRole);
        return roleMapper.toDTO(roleRepository.save(userRole));
    }

    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }

}
