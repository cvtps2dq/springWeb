package ru.cv2.springweb.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.ModelDTO;
import ru.cv2.springweb.mappers.BrandEntityMapper;
import ru.cv2.springweb.mappers.ModelEntityMapper;
import ru.cv2.springweb.repositories.ModelRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelService {
    private final ModelRepository modelRepository;
    private final BrandEntityMapper brandMapper;
    private final ModelEntityMapper modelMapper;

    public ModelService(ModelRepository modelRepository, BrandEntityMapper brandMapper, ModelEntityMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
    }

    public List<ModelDTO> getAll() {
        return modelRepository.findAll()
                .stream()
                .map(modelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ModelDTO getModelById(UUID id) {
        if (modelRepository.findById(id).isPresent())
            return modelMapper.toDTO(modelRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No model found with this UUID!");
    }

    public ModelDTO getModelByName(ModelDTO model) {

        return modelMapper.toDTO(modelRepository.findModelByName(model.getName()));
    }

    public ModelDTO saveModel(ModelDTO model) {
        return modelMapper.toDTO(modelRepository.save(modelMapper.toEntity(model)));
    }

    public ModelDTO editModel(ModelDTO updatedModel, UUID id) {
        return modelRepository.findById(id)
                .map(model -> {
                    if(updatedModel.getName() != null) {
                        model.setName(updatedModel.getName());
                    }
                    if(updatedModel.getCategory() != null) {
                        model.setCategory(updatedModel.getCategory());
                    }
                    if(updatedModel.getImageUrl() != null) {
                        model.setImageUrl(updatedModel.getImageUrl());
                    }
                    if(updatedModel.getStartYear() != null) {
                        model.setStartYear(updatedModel.getStartYear());
                    }
                    if(updatedModel.getEndYear() != null) {
                        model.setEndYear(updatedModel.getEndYear());
                    }
                    if(updatedModel.getCreated() != null) {
                        model.setCreated(updatedModel.getCreated());
                    }
                    if(updatedModel.getModified() != null) {
                        model.setModified(updatedModel.getModified());
                    }
                    if(updatedModel.getBrand() != null) {
                        model.setBrand(brandMapper.toEntity(updatedModel.getBrand()));
                    }

                    return  modelMapper.toDTO(modelRepository.save(model));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }

    public void deleteModel(UUID id) {

        modelRepository.deleteById(id);
    }

}
