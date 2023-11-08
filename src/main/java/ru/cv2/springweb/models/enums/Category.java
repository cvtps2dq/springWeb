package ru.cv2.springweb.models.enums;

public enum Category{
        Car(0),
        Bus(1),
        Truck(2),
        Motorcycle(3);
    private int category;
    private Category(int category) {
        this.category = category;
    }

}