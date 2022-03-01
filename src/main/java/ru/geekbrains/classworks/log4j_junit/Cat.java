package ru.geekbrains.classworks.log4j_junit;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
public class Cat extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Setter
    private transient String name;

    @Setter
    private String color;

    public Cat() {
        super("Cat");
        System.out.println("Cat born");
    }
    public Cat(String name, String color) {
        this();
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return String.format("Cat name: %s color: %s", name, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}