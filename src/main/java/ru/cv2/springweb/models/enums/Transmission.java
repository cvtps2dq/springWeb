package ru.cv2.springweb.models.enums;

public enum Transmission{
        Manual(0),
        Automatic(1);

    private int transmission;

    private Transmission(int transmission) {
        this.transmission = transmission;
    }
}