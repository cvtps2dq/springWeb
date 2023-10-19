package ru.cv2.springweb.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.UserRoleDTO;
import ru.cv2.springweb.models.UserEntity;
import ru.cv2.springweb.models.UserRoleEntity;

@Component
public class UserRoleEntityMapper {

    private final ModelMapper userRoleMap;

    @Autowired
    public UserRoleEntityMapper(ModelMapper userRoleMap) {
        this.userRoleMap = userRoleMap;
    }

    public UserRoleDTO toDTO (UserRoleEntity input){
        return userRoleMap.map(input, UserRoleDTO.class);
    }

    public UserRoleEntity toEntity (UserRoleDTO input){
        return userRoleMap.map(input, UserRoleEntity.class);
    }
}
