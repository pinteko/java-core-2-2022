package ru.geekbrains.homeworks.homework2;

import java.util.regex.Pattern;

public class MyMassiveClass {
    public static void main(String[] args) {
        String[][] strings = new String[4][4];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                if ((i == 2 && j == 2) || (i == 1 && j == 3)) {
                    strings[i][j] = "claus" + i + j + " ";
                } else {
                    strings[i][j] = "1" + i + j + " ";
                }
            }
        }

        try {
            System.out.println("Sum of the array = " + myMassiveMethod(strings));
        } catch (MySizeArrayException e) {
            System.out.println("The array is out of bounds");
        } catch (MyArrayDataException e) {
            System.out.println("Some array values have wrong format");
        }

    }

    public static int myMassiveMethod(String[][] str) throws MyArrayDataException, MySizeArrayException {
            if (str.length != 4 || str[0].length !=4 || str[1].length !=4 || str[2].length !=4 || str[3].length !=4) {
                throw new MySizeArrayException();
            }
            int[][] numbers = new int[4][4];
             int sum = 0;
                for (int i = 0; i < str.length; i++) {
                    for (int j = 0; j < str[i].length; j++) {
                        try {
                            if (Pattern.matches("[a-zA-Z]", str[i][j])) {
                                throw new MyArrayDataException();
                            }
                            numbers[i][j] = Integer.parseInt(str[i][j].trim());
                            sum = sum + numbers[i][j]; // лишний массив интов
                            // sum += Integer.parseInt(str[i][j]);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Wrong format on str[" + i + "]" + "[" + j + "]");
                        }
                    }
                }
            return sum;
    }
}
