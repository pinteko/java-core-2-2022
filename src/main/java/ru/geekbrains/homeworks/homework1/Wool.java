package ru.geekbrains.homeworks.homework1;

public class Wool implements Movement {

    protected String name;
    protected int powerJump;
    protected int powerRun;
    private int count;

    public Wool (String name, int powerJump, int powerRun) {
        this.name = name;
        this.powerJump = powerJump;
        this.powerRun = powerRun;
    }

    @Override
    public boolean straightRun(Barriers barriers) {
        if (powerRun >= barriers.length) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean straightJump(Barriers barriers) {
        if (powerJump >= barriers.height) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void jump(Barriers wall) {
        if (powerJump >= wall.height) {
            count++;
            System.out.printf("Wool %s jumped over the wall, count of barriers is %d\n", name, count);

        }
        else {
            System.out.printf("Wool %s too weak\n", name);
        }
    }

    @Override
    public void run(Barriers track) {
        if (powerRun >= track.length) {
            count++;
            System.out.printf("Wool %s ran down the track, count of barriers is %d\n", name, count);

        }
        else {
            System.out.printf("Wool %s too weak\n", name);
        }

    }

    public void lose () {
        System.out.printf("Wool %s end with count = %d\n", name, count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
