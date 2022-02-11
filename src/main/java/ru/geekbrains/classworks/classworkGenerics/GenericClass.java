package ru.geekbrains.classworks.classworkGenerics;

public class GenericClass<T> implements GenericInterface<T> {
    @Override
    public T doSomething(T request) {
        return null;
    }
}

//public class GenericClass implements GenericInterface<String> {
//    @Override
//    public String doSomething(String request) {
//        return null;
//    }
//}