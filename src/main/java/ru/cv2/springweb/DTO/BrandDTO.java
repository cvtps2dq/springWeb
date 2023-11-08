package ru.cv2.springweb.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class BrandDTO {

    private String name;

    private UUID uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public BrandDTO() {
    }

    private BrandDTO(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }
}

