package ru.geekbrains.homeworks.homework3;

import java.util.Objects;

public class PhoneBook implements Comparable<PhoneBook>{

    private String name;
    private int number;

    public PhoneBook(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void get(String name) {
        if (name.equals(this.name)) {
            System.out.println(name + "'s number is " + this.number);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhoneBook pB = (PhoneBook) obj;
        return number == pB.number;
    }

    @Override
    public String toString() {
        return name + "'s number is " + number;
    }

    @Override
    public int compareTo(PhoneBook o) {
        return this.number - o.number;
    }
}
