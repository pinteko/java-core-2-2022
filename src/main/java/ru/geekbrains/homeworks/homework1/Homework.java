package ru.geekbrains.homeworks.homework1;

public class Homework {
    public static void main(String[] args) {

        Movement[] players = {
                new Robocop("Steel", 50, 200),
                new Robocop("Titan", 40, 220),
                new Robocop("Lithium", 60, 180),
                new Skin("John", 20, 100),
                new Skin("Billie", 18, 110),
                new Skin("Bob", 22, 90),
                new Wool("Cooper", 40, 150),
                new Wool("Barney", 45, 130),
                new Wool("Cliff", 35, 170)
        };

        Barriers[] barriers = {
                new RunningTrack(100),
                new Wall(20),
                new RunningTrack(200),
                new Wall(35),
                new RunningTrack(300),
                new Wall(51)
        };

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                if (barriers[j] instanceof RunningTrack) {
                    if (players[i].straightRun(barriers[j])) {
                        players[i].run(barriers[j]);
                    }
                    else {
                        players[i].lose();
                        break;
                    }
                }
                else {
                    if (players[i].straightJump(barriers[j])) {
                        players[i].jump(barriers[j]);
                    }
                    else {
                        players[i].lose();
                        break;
                    }
                }
            }
        }

    }
}
