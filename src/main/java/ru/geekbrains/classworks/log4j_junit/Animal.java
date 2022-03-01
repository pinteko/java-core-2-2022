package ru.geekbrains.classworks.log4j_junit;

import java.io.Serializable;

public class Animal implements Serializable {
    private String type;

    public Animal(String type) {
        this.type = type;
        System.out.println("Animal born");
    }
}
