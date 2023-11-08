package ru.cv2.springweb.services;

import ru.cv2.springweb.DTO.OfferDTO;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    List<OfferDTO> getAll();
    OfferDTO getOfferById(UUID id);
    OfferDTO saveOffer(OfferDTO brand);
    OfferDTO editOffer(OfferDTO updatedOffer, UUID id);
    void deleteOffer(UUID id);

}
