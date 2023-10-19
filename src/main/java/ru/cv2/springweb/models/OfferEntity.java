package ru.cv2.springweb.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.cv2.springweb.models.enums.Engine;
import ru.cv2.springweb.models.enums.Transmission;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class OfferEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String description;

    @Enumerated(EnumType.STRING)
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private Float price;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="model_id")
    private ModelEntity model;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="selled_id")
    private UserEntity seller;

    private OfferEntity(UUID uuid, String description, Engine engine, String imageUrl, Integer mileage, Float price, Transmission transmission, Integer year, LocalDateTime created, LocalDateTime modified, ModelEntity model, UserEntity seller) {
        this.uuid = uuid;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
    }

    public OfferEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }
}
