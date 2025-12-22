package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FlatMapTest {
    String name;
    int id;
    char grade;

    FlatMapTest(String name, int id, char grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}

public class FlatMapDemo {

    public static void main(String[] args) {
        List<FlatMapTest> list = new ArrayList<>();
        list.add(new FlatMapTest("Mahi", 1, 'A'));
        list.add(new FlatMapTest("Raina", 2, 'B'));
        list.add(new FlatMapTest("Yuvi", 3, 'C'));

        List<FlatMapTest> list1 = new ArrayList<>();
        list.add(new FlatMapTest("sachin", 4, 'D'));
        list.add(new FlatMapTest("Sehvag", 5, 'E'));
        list.add(new FlatMapTest("Dravid", 6, 'F'));

        List<FlatMapTest> list2 = new ArrayList<>();
        list.add(new FlatMapTest("Rohit", 7, 'G'));
        list.add(new FlatMapTest("Dhavan", 8, 'H'));
        list.add(new FlatMapTest("Virat", 9, 'I'));

        List<List<FlatMapTest>> list3 = Arrays.asList(list, list1, list2);
        list3.stream()
                .flatMap(playersList -> playersList
                        .stream()
                        .map(player -> player.id + " " + player.name + " " + player.grade))
                .forEach(System.out::println);

        // OR
        list3.stream()
                .flatMap(playersList -> playersList
                        .stream()
                        .map(i -> i.name))
                .forEach(System.out::println);

        List<String> list4 = list3.stream()
                .flatMap(playersList -> playersList
                        .stream()
                        .map(i -> i.name))
                .collect(Collectors.toList());
        System.out.println(list4);
    }
}
