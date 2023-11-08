package ru.cv2.springweb.services;

import ru.cv2.springweb.DTO.BrandDTO;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<BrandDTO> getAll();
    BrandDTO getBrandByName(String name);
    BrandDTO saveBrand(BrandDTO brand);
    BrandDTO editBrand(BrandDTO updatedBrand, UUID id);
    void deleteBrand(UUID id);

}
