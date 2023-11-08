package ru.cv2.springweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.OfferDTO;
import ru.cv2.springweb.mappers.ModelEntityMapper;
import ru.cv2.springweb.mappers.OfferEntityMapper;
import ru.cv2.springweb.mappers.UserEntityMapper;
import ru.cv2.springweb.repositories.OfferRepository;
import ru.cv2.springweb.services.OfferService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private final ModelEntityMapper modelMapper;
    private final OfferEntityMapper offerMapper;
    private final UserEntityMapper userMapper;

    @Autowired
    public OfferServiceImpl(ModelEntityMapper modelMapper, OfferEntityMapper offerMapper, UserEntityMapper userMapper) {
        this.modelMapper = modelMapper;
        this.offerMapper = offerMapper;
        this.userMapper = userMapper;
    }

    @Autowired
    public void setOfferRepository(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }
    @Override
    public List<OfferDTO> getAll() {
        return offerRepository.findAll()
                .stream()
                .map(offerMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public OfferDTO getOfferById(UUID id) {
        if (offerRepository.findById(id).isPresent())
            return offerMapper.toDTO(offerRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No model found with this UUID!");
    }
    @Override
    public OfferDTO saveOffer(OfferDTO offer) {
        return offerMapper.toDTO(offerRepository.save(offerMapper.toEntity(offer)));
    }
    @Override
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
    @Override
    public void deleteOffer(UUID id) {
        offerRepository.deleteById(id);
    }

}