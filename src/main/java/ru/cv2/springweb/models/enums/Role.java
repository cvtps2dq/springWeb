package ru.cv2.springweb.models.enums;

public enum Role{
        User(0),
        Admin(1);

    private int role;

    private Role(int role) {
        this.role = role;
    }
}