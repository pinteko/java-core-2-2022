package ru.geekbrains.homeworks.reflections_anotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

@Check
public class MyClass {
  private MyMassive workMassive;
    private final int[] numbers = {5, 6, 7, 1, 8};
    private final int[] numbersTwo = {1, 6, 7, 4, 8};
    private final int[] bullets = {1, 4, 7, 9, 4, 6, 7};
    private final int[] bulletsTwo = {1, 4, 7, 9, 4, 6, 4};
    private final int[] eq = {6, 7};
    private final int[] eqTwo = {};
    private final String success = "success";
    private final String fail = "fail";
    private final ArrayList<String> generalResult = new ArrayList<>();
    private File information = new File("src/main/resources/information");

    public ArrayList<String> getGeneralResult() {
        return generalResult;
    }

    @Test(priority = 1)
    private void cat() {
      String info = " on cat method";
        if (Arrays.equals(workMassive.changeMassive(bullets), eq)) {
            generalResult.add(success + info);
        }
        else {
            generalResult.add(fail + info);
        }
    }

    @Test(priority = 2)
    private void dog() {
      String info = " on dog method";
      if (Arrays.equals(workMassive.changeMassive(bullets), eqTwo)) {
        generalResult.add(success + info);
      }
      else {
        generalResult.add(fail + info);
      }
    }

    @Test(priority = 3)
    private void mouse() {
      String info = " on mouse method";
      if (workMassive.searchMassive(numbers)) {
        generalResult.add(success + info);
      }
      else {
        generalResult.add(fail + info);
      }
    }

    @Test(priority = 4)
    private void snake() {
      String info = " on snake method";
      if (workMassive.searchMassive(numbersTwo)) {
        generalResult.add(success + info);
      }
      else {
        generalResult.add(fail + info);
      }
    }

    @Test(priority = 4)
    private void elephant() {
      if (!information.exists()) {generalResult.add("No exists file 'information'");}
     else {
        try (BufferedReader reader = new BufferedReader(new FileReader(information))) {
          String infoString;
          if ((infoString = reader.readLine()) != null) {
            generalResult.add(infoString);
          }
          else {generalResult.add("File 'information' is empty");}
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }

    }

    @Test(priority = 6)
    private void monkey() {
      generalResult.add("six");
    }

    @Test(priority = 7)
    private void tiger() {
      generalResult.add("seven");
    }

    @Test(priority = 8)
    private void puma() {
      generalResult.add("eight");
    }

    @Test(priority = 9)
    private void leopard() {
      generalResult.add("nine");
    }

    @Test(priority = 10)
    private void leon() {
      generalResult.add("ten");
    }

    @AfterSuite
    private void animal() {
    generalResult.add("Testing is done");
    }

    @BeforeSuite
    private void earth() {
    workMassive = new MyMassive();
      generalResult.add("Testing was started");
    }

}
