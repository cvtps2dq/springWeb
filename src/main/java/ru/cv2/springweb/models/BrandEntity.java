package ru.cv2.springweb.models;

import jakarta.persistence.*;
import ru.cv2.springweb.models.abstracts.BaseCMEntity;
import ru.cv2.springweb.models.abstracts.BaseEntity;

import java.util.List;

@Entity
public class BrandEntity extends BaseCMEntity {

    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<ModelEntity> models;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public BrandEntity() {
    }

    private BrandEntity(String name) {
        this.name = name;
    }
}
