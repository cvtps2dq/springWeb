package ru.cv2.springweb.models.enums;

public enum Engine{
        Gasoline(0),
        Diesel(1),
        Electric(2),
        Hybrid(3);

    private int engine;

    private Engine(int engine) {
        this.engine = engine;
    }
}