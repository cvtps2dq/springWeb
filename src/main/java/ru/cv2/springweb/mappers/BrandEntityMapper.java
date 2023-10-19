package ru.cv2.springweb.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.BrandDTO;
import ru.cv2.springweb.models.BrandEntity;

@Component
public class BrandEntityMapper {

    private final ModelMapper brandMap;

    @Autowired
    public BrandEntityMapper(ModelMapper brandMap) {
        this.brandMap = brandMap;
    }

    public BrandDTO toDTO (BrandEntity input){
        return brandMap.map(input, BrandDTO.class);
    }

    public BrandEntity toEntity (BrandDTO input){
        return brandMap.map(input, BrandEntity.class);
    }
}
