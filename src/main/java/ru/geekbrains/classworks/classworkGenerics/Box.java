package ru.geekbrains.classworks.classworkGenerics;

public class Box {
    private Object obj;

    public Box (Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
