package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1.

        int[] intArray = {1, 2, 3, 4, 5, 1, 2, 3};
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = Arrays.stream(intArray).boxed().toList();
        list.forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        map.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(key);
            }
        });


        // 2.

        String[] strArray = {"Mahantesh", "Shrinav", "Chinnu", "Chhotya"};
        List<String> list1 = Arrays.stream(strArray).toList();
        list1.stream().forEach(name -> {
            String reverse = "";
            for (int i = name.length() - 1; i >= 0; i--) {
                reverse += name.charAt(i);
            }
            System.out.println(reverse);
        });

    }
}