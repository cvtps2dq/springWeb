package ru.cv2.springweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cv2.springweb.models.ModelEntity;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, UUID> {
    ModelEntity findModelByName(String name);
}
