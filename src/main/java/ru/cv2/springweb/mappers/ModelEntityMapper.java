package ru.cv2.springweb.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.BrandDTO;
import ru.cv2.springweb.DTO.ModelDTO;
import ru.cv2.springweb.models.ModelEntity;

@Component
public class ModelEntityMapper {

    private final ModelMapper modelMap;

    @Autowired
    public ModelEntityMapper(ModelMapper modelMap) {
        this.modelMap = modelMap;
    }

    public ModelDTO toDTO (ModelEntity input){
        return modelMap.map(input, ModelDTO.class);
    }

    public ModelEntity toEntity (ModelDTO input){
        return modelMap.map(input, ModelEntity.class);
    }
}
