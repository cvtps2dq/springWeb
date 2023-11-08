package ru.cv2.springweb.DTO;

import ru.cv2.springweb.models.enums.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModelDTO {
    private String name;
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private BrandDTO brand;

    private UUID id;

    public ModelDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private ModelDTO(String name, Category category, String imageUrl, Integer startYear, Integer endYear, BrandDTO brand, UUID id) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
        this.id = id;
    }
}
