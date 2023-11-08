package ru.cv2.springweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.UserRoleDTO;
import ru.cv2.springweb.mappers.UserEntityMapper;
import ru.cv2.springweb.mappers.UserRoleEntityMapper;
import ru.cv2.springweb.models.UserRoleEntity;
import ru.cv2.springweb.repositories.UserRoleRepository;
import ru.cv2.springweb.services.UserRoleService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleRepository roleRepository;
    private final UserRoleEntityMapper roleMapper;
    private final UserEntityMapper userMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleEntityMapper roleMapper, UserEntityMapper userMapper) {
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<UserRoleDTO> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public UserRoleDTO getRoleById(UUID id) {
        if (roleRepository.findById(id).isPresent())
            return roleMapper.toDTO(roleRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No role found with this UUID!");
    }
    @Override
    public UserRoleDTO saveRole(UserRoleDTO role) {
        return roleMapper.toDTO(roleRepository.save(roleMapper.toEntity(role)));
    }
    @Override
    public UserRoleDTO updateUserRole(UUID id, UserRoleDTO userRoleDto) {
        UserRoleEntity userRole = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("UserRole not found"));

        // Обновление поля роли
        userRole.setRole(userRoleDto.getRole());

        UserRoleEntity updatedUserRole = roleRepository.save(userRole);
        return roleMapper.toDTO(roleRepository.save(userRole));
    }
    @Override
    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }

}
