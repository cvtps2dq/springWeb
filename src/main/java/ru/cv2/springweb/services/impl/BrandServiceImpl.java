package ru.cv2.springweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cv2.springweb.DTO.BrandDTO;
import ru.cv2.springweb.mappers.BrandEntityMapper;
import ru.cv2.springweb.repositories.BrandRepository;
import ru.cv2.springweb.services.BrandService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    private final BrandEntityMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandEntityMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
    @Override
    public List<BrandDTO> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public BrandDTO getBrandByName(String name) {

        return brandMapper.toDTO(brandRepository.findBrandByName(name));
    }

    @Override
    public BrandDTO saveBrand(BrandDTO brand) {
        return brandMapper.toDTO(brandRepository.save(brandMapper.toEntity(brand)));
    }
    @Override
    public BrandDTO editBrand(BrandDTO updatedBrand, UUID id) {
        return brandRepository.findById(id)
                .map(brand -> {
                    if(updatedBrand.getName() != null) {
                        brand.setName(updatedBrand.getName());
                    }
                    return brandMapper.toDTO(brandRepository.save(brand));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update brand: no such brand"));
    }
    @Override
    public void deleteBrand(UUID id) {

        brandRepository.deleteById(id);
    }

}
