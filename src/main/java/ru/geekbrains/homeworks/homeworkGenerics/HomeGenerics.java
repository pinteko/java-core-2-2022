package ru.geekbrains.homeworks.homeworkGenerics;

import ru.geekbrains.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeGenerics {
    public static void main(String[] args) {

        Apple oneA = new Apple();
        Apple twoA = new Apple();
        Apple threeA = new Apple();
        Orange oneO = new Orange();
        Orange twoO = new Orange();
        var boxApple = new FruitBox<Apple>();
        var boxApple2 = new FruitBox<Apple>();
        var boxOrange = new FruitBox<Orange>();
        boxApple.addFruit(oneA);
        boxApple.addFruit(twoA);
        boxApple.addFruit(threeA);
        boxOrange.addFruit(oneO);
        boxOrange.addFruit(twoO);
        System.out.println(boxApple);
        System.out.println(boxApple2);
        System.out.println(boxOrange);
        System.out.println("First apple box weight is " +  boxApple.getWeight());
        System.out.println("Two apple box weight is " +  boxApple2.getWeight());
        System.out.println("Orange box weight is " +  boxOrange.getWeight());
        System.out.println(boxApple.compare(boxOrange));
        boxApple2.intersperse(boxApple);
        System.out.println("First apple box weight is " +  boxApple.getWeight());
        System.out.println("Two apple box weight is " +  boxApple2.getWeight());
    }

    private static <T> void changePlace(T[] massive, int firstCell, int  anotherCell) {
        try {
            var helper = massive[firstCell];
            massive[firstCell] = massive[anotherCell];
            massive[anotherCell] = helper;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of massive length");
        }
    }

    private static <T> ArrayList<T> reformatToList(T[] massive) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(massive));
        return list;
    }
}
