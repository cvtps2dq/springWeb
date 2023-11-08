package ru.cv2.springweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.ModelDTO;
import ru.cv2.springweb.mappers.BrandEntityMapper;
import ru.cv2.springweb.mappers.ModelEntityMapper;
import ru.cv2.springweb.repositories.ModelRepository;
import ru.cv2.springweb.services.ModelService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private final BrandEntityMapper brandMapper;
    private final ModelEntityMapper modelMapper;

    @Autowired
    public ModelServiceImpl(BrandEntityMapper brandMapper, ModelEntityMapper modelMapper) {
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
    @Override
    public List<ModelDTO> getAll() {
        return modelRepository.findAll()
                .stream()
                .map(modelMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ModelDTO getModelById(UUID id) {
        if (modelRepository.findById(id).isPresent())
            return modelMapper.toDTO(modelRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No model found with this UUID!");
    }
    @Override
    public ModelDTO getModelByName(String name) {

        return modelMapper.toDTO(modelRepository.findModelByName(name));
    }
    @Override
    public ModelDTO saveModel(ModelDTO model) {
        return modelMapper.toDTO(modelRepository.save(modelMapper.toEntity(model)));
    }
    @Override
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
                    if(updatedModel.getBrand() != null) {
                        model.setBrand(brandMapper.toEntity(updatedModel.getBrand()));
                    }

                    return  modelMapper.toDTO(modelRepository.save(model));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }
    @Override
    public void deleteModel(UUID id) {

        modelRepository.deleteById(id);
    }

}
