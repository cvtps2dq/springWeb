package ru.cv2.springweb.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.BrandDTO;
import ru.cv2.springweb.mappers.BrandEntityMapper;
import ru.cv2.springweb.repositories.BrandRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandEntityMapper brandMapper;

    public BrandService(BrandRepository brandRepository, BrandEntityMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    public List<BrandDTO> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BrandDTO getBrandById(UUID id) {
        if (brandRepository.findById(id).isPresent())
            return brandMapper.toDTO(brandRepository.findById(id).get());
        else
            throw new IllegalArgumentException("No brand found with this UUID!");
    }

    public BrandDTO getBrandByName(BrandDTO brand) {

        return brandMapper.toDTO(brandRepository.findBrandByName(brand.getName()));
    }


    public BrandDTO saveBrand(BrandDTO brand) {
        return brandMapper.toDTO(brandRepository.save(brandMapper.toEntity(brand)));
    }

    public BrandDTO editBrand(BrandDTO updatedBrand, UUID id) {
        return brandRepository.findById(id)
                .map(brand -> {
                    if(updatedBrand.getCreated() != null) {
                        brand.setCreated(updatedBrand.getCreated());
                    }
                    if(updatedBrand.getName() != null) {
                        brand.setName(updatedBrand.getName());
                    }
                    if(updatedBrand.getModified() != null) {
                        brand.setModified(updatedBrand.getModified());
                    }

                    return brandMapper.toDTO(brandRepository.save(brand));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }

    public void deleteBrand(UUID id) {

        brandRepository.deleteById(id);
    }

}
