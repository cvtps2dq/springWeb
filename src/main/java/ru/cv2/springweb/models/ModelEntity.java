package ru.cv2.springweb.models;

import jakarta.persistence.*;
import ru.cv2.springweb.models.enums.Category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class ModelEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="brand_id")
    private BrandEntity brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.PERSIST)
    private List<OfferEntity> offers;

    private ModelEntity(UUID uuid, String name, Category category, String imageUrl, Integer startYear, Integer endYear, LocalDateTime created, LocalDateTime modified, BrandEntity brand) {
        this.uuid = uuid;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    public ModelEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
