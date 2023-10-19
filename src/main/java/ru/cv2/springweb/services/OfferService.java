package ru.cv2.springweb.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.OfferDTO;
import ru.cv2.springweb.mappers.ModelEntityMapper;
import ru.cv2.springweb.mappers.OfferEntityMapper;
import ru.cv2.springweb.mappers.UserEntityMapper;
import ru.cv2.springweb.repositories.OfferRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final ModelEntityMapper modelMapper;
    private final OfferEntityMapper offerMapper;

    private final UserEntityMapper userMapper;
    public OfferService(OfferRepository offerRepository, ModelEntityMapper modelMapper, OfferEntityMapper offerMapper, UserEntityMapper userMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.offerMapper = offerMapper;
        this.userMapper = userMapper;
    }

    public List<OfferDTO> getAll() {
        return offerRepository.findAll()
                .stream()
                .map(offerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OfferDTO getOfferById(UUID id) {
        if (offerRepository.findById(id).isPresent())
            return offerMapper.toDTO(offerRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No model found with this UUID!");
    }

    public OfferDTO saveOffer(OfferDTO offer) {
        return offerMapper.toDTO(offerRepository.save(offerMapper.toEntity(offer)));
    }

    public OfferDTO editOffer(OfferDTO updatedOffer, UUID id) {
        return offerRepository.findById(id)
                .map(model -> {
                    if(updatedOffer.getDescription() != null) {
                        model.setDescription(updatedOffer.getDescription());
                    }
                    if(updatedOffer.getEngine() != null) {
                        model.setEngine(updatedOffer.getEngine());
                    }
                    if(updatedOffer.getImageUrl() != null) {
                        model.setImageUrl(updatedOffer.getImageUrl());
                    }
                    if(updatedOffer.getMileage() != null) {
                        model.setMileage(updatedOffer.getMileage());
                    }
                    if(updatedOffer.getPrice() != null) {
                        model.setPrice(updatedOffer.getPrice());
                    }
                    if(updatedOffer.getTransmission() != null) {
                        model.setTransmission(updatedOffer.getTransmission());
                    }
                    if(updatedOffer.getYear() != null) {
                        model.setYear(updatedOffer.getYear());
                    }
                    if(updatedOffer.getCreated() != null) {
                        model.setCreated(updatedOffer.getCreated());
                    }
                    if(updatedOffer.getModified() != null) {
                        model.setModified(updatedOffer.getModified());
                    }
                    if(updatedOffer.getModel() != null) {
                        model.setModel(modelMapper.toEntity(updatedOffer.getModel()));
                    }
                    if(updatedOffer.getSeller() != null) {
                        model.setSeller(userMapper.toEntity(updatedOffer.getSeller()));
                    }
                    return  offerMapper.toDTO(offerRepository.save(model));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }

    public void deleteOffer(UUID id) {
        offerRepository.deleteById(id);
    }

}