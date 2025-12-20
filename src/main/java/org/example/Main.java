package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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

        // 3. Filter()

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> filteredValues = list2.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(filteredValues);

        list2.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
        list2.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        List<String> names = new ArrayList<>(Arrays.asList("Mahantesh", null, "Kiranagi", "Ram", "sham", "Tom", null));
        names.stream().filter(value -> value != null).forEach(System.out::println);
        List<String> nonNullValues = names.stream().filter(value -> value != null).collect(Collectors.toList());

        nonNullValues.stream().filter(name -> name.length() > 6 && name.length() < 10).forEach(name -> System.out.println(name));
        nonNullValues.stream().filter(name -> name.length() > 6 && name.length() < 10).forEach(System.out::println);

        // 4.

        List<String> list3 = Arrays.asList("Mahantesh", "Kiranagi", "TSYS", "Global", "Payments");
        String str = list3.stream().collect(Collectors.joining());
        String str1 = list3.stream().collect(Collectors.joining(","));
        String str2 = list3.stream().collect(Collectors.joining(",", "(", ")"));
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);

        // 5.


    }
}