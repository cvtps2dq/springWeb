package ru.cv2.springweb.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class BrandDTO {

    private UUID uuid;
    private String name;
    public LocalDateTime created;
    public LocalDateTime modified;

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

    public BrandDTO() {
    }

    private BrandDTO(UUID uuid, String name, LocalDateTime created, LocalDateTime modified) {
        this.uuid = uuid;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }
}

