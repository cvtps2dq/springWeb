package ru.cv2.springweb.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.UserDTO;
import ru.cv2.springweb.models.UserEntity;

@Component
public class UserEntityMapper {

    private final ModelMapper userMap;

    @Autowired
    public UserEntityMapper(ModelMapper userMap) {
        this.userMap = userMap;
    }

    public UserDTO toDTO (UserEntity input){
        return userMap.map(input, UserDTO.class);
    }

    public UserEntity toEntity (UserDTO input){
        return userMap.map(input, UserEntity.class);
    }
}

