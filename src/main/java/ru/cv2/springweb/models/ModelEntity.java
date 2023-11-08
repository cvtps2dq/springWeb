package ru.cv2.springweb.models;

import jakarta.persistence.*;
import ru.cv2.springweb.models.abstracts.BaseCMEntity;
import ru.cv2.springweb.models.abstracts.BaseEntity;
import ru.cv2.springweb.models.enums.Category;

import java.util.List;

@Entity
public class ModelEntity extends BaseCMEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="brand_id")
    private BrandEntity brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.PERSIST)
    private List<OfferEntity> offers;

    private ModelEntity(String name, Category category, String imageUrl, Integer startYear, Integer endYear, BrandEntity brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public ModelEntity() {
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

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
