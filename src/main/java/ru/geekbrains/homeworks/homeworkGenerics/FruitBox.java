package ru.geekbrains.homeworks.homeworkGenerics;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<F extends Fruit> {
    private ArrayList<F> fruit;

    public FruitBox() {
        this.fruit = new ArrayList<F>();
    }

    public void  addFruit(F fruit) {
        this.fruit.add(fruit);
    }

    public boolean compare(FruitBox<?> fruitBox) {
        return this.getWeight() == fruitBox.getWeight();
    }

    public void intersperse(FruitBox<F> fruitBox) {
            this.fruit.addAll(fruitBox.getFruit());
            fruitBox.getFruit().clear();

    }

    public double getWeight() {
        double weight;
        if (this.fruit.isEmpty()) {
            weight = 0;
        }
        else if (fruit.get(0).getClass().getSimpleName().equals("Apple")) {
            weight = fruit.size() * Apple.weight;
        }
        else {
            weight = fruit.size() * Orange.weight;
        }
        return weight;
    }


    public ArrayList<F> getFruit() {
        return fruit;
    }

    public void setFruit(ArrayList<F> fruit) {
        this.fruit = fruit;
    }

    public void setFruit(F[] massive) {
        this.fruit = new ArrayList<>(Arrays.asList(massive));
    }

    @Override
    public String toString() {
        String str = "";
        if (fruit.isEmpty()) {
            str = "Box is empty";
        }
         for (int i = 0; i < fruit.size(); i++) {
            str = str + "[" + fruit.get(i).getClass().getSimpleName() + "] ";
        }
        return str;
    }

    }
