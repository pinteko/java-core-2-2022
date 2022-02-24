package ru.geekbrains.classworks.classworkDataBase;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(String message) {
        super(message);
    }
}
