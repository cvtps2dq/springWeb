package ru.cv2.springweb.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class BrandEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    public LocalDateTime created;
    public LocalDateTime modified;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<ModelEntity> models;

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

    public BrandEntity() {
    }

    private BrandEntity(UUID uuid, String name, LocalDateTime created, LocalDateTime modified) {
        this.uuid = uuid;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }
}
