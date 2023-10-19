package ru.cv2.springweb.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.OfferDTO;
import ru.cv2.springweb.models.OfferEntity;

@Component
public class OfferEntityMapper {

    private final ModelMapper offerMap;

    @Autowired
    public OfferEntityMapper(ModelMapper offerMap) {
        this.offerMap = offerMap;
    }

    public OfferDTO toDTO (OfferEntity input){
        return offerMap.map(input, OfferDTO.class);
    }

    public OfferEntity toEntity (OfferDTO input){
        return offerMap.map(input, OfferEntity.class);
    }
}
