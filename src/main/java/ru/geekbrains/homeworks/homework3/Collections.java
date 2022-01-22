package ru.geekbrains.homeworks.homework3;

import java.util.*;
import java.util.function.Predicate;

public class Collections {

    public static void main(String[] args) {
       uniqueWords();
        phoneBook();
    }

    public static void phoneBook() {

        Set<PhoneBook> members = new TreeSet<>();

        members.add(new PhoneBook("Billie",3456));
        members.add(new PhoneBook("John",34575));
        members.add(new PhoneBook("Nick",679678));
        members.add(new PhoneBook("Bob",145243));
        members.add(new PhoneBook("John",345645));
        members.add(new PhoneBook("Sully",247754));
        members.add(new PhoneBook("Bob",4564743));
        members.add(new PhoneBook("Nicole",434674));
        members.add(new PhoneBook("Nicole",57885));

        for (PhoneBook pB: members) {
            pB.get("John");
        }

    }



    public static void uniqueWords() {
        List<String> words = new ArrayList<>(Arrays.asList("Big", "Small", "Tall", "Full", "Big",
                "Old", "Young", "Fast", "Young", "Tall", "Big", "Easy", "Small", "Young"));

        for (int i = 0; i < words.size(); i++) {
            String firstWord = words.get(i);
            int count = 1;
            for (int j = i + 1; j < words.size(); j++) {
                String twoWord = words.get(j);
                if (firstWord.equals(twoWord)) {
                    count++;
                    words.remove(j);
                }
            }
            System.out.printf("Count of words like %s is %d\n", firstWord, count);
        }
        System.out.println("Unique words: " + words);
    }
}
