package ru.geekbrains.homeworks.homework1;

public interface Movement {
    void jump (Barriers wall);
    void run(Barriers track);
    boolean straightRun(Barriers track);
    boolean straightJump(Barriers wall);
    void lose ();
}