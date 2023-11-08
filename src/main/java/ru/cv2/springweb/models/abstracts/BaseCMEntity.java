package ru.cv2.springweb.models.abstracts;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseCMEntity extends BaseEntity {
    private LocalDateTime created;
    private LocalDateTime modified;

    public LocalDateTime getCreated() {
        return created;
    }

    @PrePersist
    public void setCreated() {
        created = LocalDateTime.now();
    }

    public LocalDateTime getModified() {
        return modified;
    }
    @PreUpdate
    public void setModified() {
        modified = LocalDateTime.now();
    }

    private BaseCMEntity(LocalDateTime created, LocalDateTime modified) {
        this.created = created;
        this.modified = modified;
    }

    public BaseCMEntity() {
    }
}
