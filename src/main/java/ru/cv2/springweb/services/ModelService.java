package ru.cv2.springweb.services;

import ru.cv2.springweb.DTO.BrandDTO;
import ru.cv2.springweb.DTO.ModelDTO;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    List<ModelDTO> getAll();
    ModelDTO getModelById(UUID id);
    ModelDTO getModelByName(ModelDTO brand);
    ModelDTO saveModel(ModelDTO brand);
    ModelDTO editModel(ModelDTO updatedModel, UUID id);
    void deleteModel(UUID id);

}