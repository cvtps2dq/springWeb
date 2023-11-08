package ru.cv2.springweb.models;

import jakarta.persistence.*;
import ru.cv2.springweb.models.abstracts.BaseCMEntity;
import ru.cv2.springweb.models.abstracts.BaseEntity;

@Entity
public class UserEntity extends BaseCMEntity {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="role_id")
    private UserRoleEntity role;
    private String imageUrl;

    private UserEntity(String username, String password, String firstName, String lastName, Boolean isActive, UserRoleEntity role, String imageUrl) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.role = role;
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public void setRole(UserRoleEntity role) {
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserEntity() {
    }
}
