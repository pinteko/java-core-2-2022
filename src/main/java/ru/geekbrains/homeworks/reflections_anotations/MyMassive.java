package ru.geekbrains.homeworks.reflections_anotations;

import java.util.Arrays;

public class MyMassive {

    public int[] changeMassive(int[] massive) {
        int count = 0;
        int[] newMassive = null;
        if (massive == null) {
            return null;
        }
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == 4) {
                count = i;
            }
        }
        if (count != 0) {
            newMassive = new int[massive.length - (count + 1)];
            System.arraycopy(massive, count + 1, newMassive, 0, massive.length - (count + 1));
        }
        else {
            throw new RuntimeException("Not found number 4");
        }
        return newMassive;
    }

    public boolean searchMassive(int[] massive) {
        if (massive == null) {
            return false;
        }
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == 1 || massive[i] == 4) {
                int count = massive[i];
                if (count == 1) {
                    for (int j = i + 1; j < massive.length; j++) {
                        if (massive[j] == 4) {
                            return true;
                        }
                    }
                }
                else if (count == 4) {
                    for (int j = i + 1; j < massive.length; j++) {
                        if (massive[j] == 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
