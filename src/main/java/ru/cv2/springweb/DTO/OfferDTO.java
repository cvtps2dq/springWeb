package ru.cv2.springweb.DTO;

import ru.cv2.springweb.models.enums.Engine;
import ru.cv2.springweb.models.enums.Transmission;

import java.time.LocalDateTime;
import java.util.UUID;

public class OfferDTO {
    private String description;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private Float price;
    private Transmission transmission;
    private Integer year;
    private ModelDTO model;
    private UserDTO seller;
    private UUID id;

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

    public ModelDTO getModel() {
        return model;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }

    public UserDTO getSeller() {
        return seller;
    }

    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OfferDTO() {
    }

    private OfferDTO(String description, Engine engine, String imageUrl, Integer mileage, Float price, Transmission transmission, Integer year, ModelDTO model, UserDTO seller, UUID id) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
        this.id = id;
    }
}
