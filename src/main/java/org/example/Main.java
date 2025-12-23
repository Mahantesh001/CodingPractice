package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        // 5. map()

        List<Integer> list11 = Arrays.asList(1, 2, 3, 2, 6, 7);
        List<Integer> mappedList = list11.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(mappedList);
        List<Integer> mappedList1 = list11.stream().map(n -> n * 2).toList();
        System.out.println(mappedList1);

        list11.stream().map(n -> n * 2).forEach(n -> System.out.println(n));
        list11.stream().map(n -> n * 2).forEach(System.out::println);

        // 6. Combination of filter() + map()

        list11.stream().filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);

        // 7. flatMap()

        List<Integer> listt1 = Arrays.asList(1, 2);
        List<Integer> listt2 = Arrays.asList(3, 4);
        List<Integer> listt3 = Arrays.asList(5, 6);
        List<Integer> listt4 = Arrays.asList(7, 8);

        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(listt1);
        finalList.add(listt2);
        finalList.add(listt3);
        finalList.add(listt4);

        // OR List<List<Integer>> finalList = Arrays.asList(listt1, listt2, listt3, listt4);

        List<Integer> list5 = finalList.stream().flatMap(n -> n.stream().map(m -> m * 2)).collect(Collectors.toList());
        System.out.println(list5);
        // OR
        List<Integer> list6 = finalList.stream().flatMap(n -> n.stream().map(m -> m * 2)).toList();
        System.out.println(list6);
        // OR
        finalList.stream().flatMap(n -> n.stream().map(m -> m * 2)).forEach(System.out::println);
        finalList.stream().flatMap(n -> n.stream().map(m -> m * 2)).forEach(l -> System.out.println(l));

        // 8. distinct()

        List<String> lista = Arrays.asList("Mahi", "Yuvi", "Bhuvi", "Mahi", "Yuvi");
        List<String> listb = lista.stream().distinct().collect(Collectors.toList());
        System.out.println(listb);

        // OR
        List<String> listc = lista.stream().distinct().toList();
        System.out.println(listc);

        // OR
        lista.stream().distinct().forEach(n -> System.out.println(n));

        // OR
        lista.stream().distinct().forEach(System.out::println);

        // 9. count()

        long count = lista.stream().distinct().count();
        System.out.println(count);

        // 10. limit()

        lista.stream().limit(4).forEach(System.out::println);

        long count1 = lista.stream().distinct().limit(2).count();
        System.out.println(count1);

        // 11. min() & max()

        List<Integer> lisst = Arrays.asList(2, 6, 1, 9, 10, 40, 10, 5);

        // min()

        Optional<Integer> minValue = lisst.stream().min((value1, value2) -> {
            return value1.compareTo(value2);
        });
        System.out.println(minValue.get());
        // OR
        Optional<Integer> minValue1 = lisst.stream().min(Integer::compareTo);
        System.out.println(minValue1.get());

        // max()

        Optional<Integer> maxValue = lisst.stream().max((value1, value2) -> {
            return value1.compareTo(value2);
        });
        System.out.println(maxValue.get());
        // OR
        Optional<Integer> maxValue1 = lisst.stream().max(Integer::compareTo);
        System.out.println(maxValue1.get());

        // 12. reduce()

        Optional<Integer> opt = lisst.stream().reduce((accumulator, element) -> {
            return accumulator + element;
        });
        System.out.println(opt.get());

        Optional<Integer> opt1 = lisst.stream().reduce(10, (accumulator, element) -> {
            return accumulator + element;
        }).describeConstable();
        System.out.println(opt1.get());

        // 13. toArray()

        Object[] arr = lisst.stream().toArray();
        System.out.println(arr[2]);
        System.out.println(arr.length);
        for (Object obj : arr) {
            System.out.println(obj);
        }

        // 14. sorted()

        List<Integer> listaa = Arrays.asList(4, 7, 2, 9, 1, 6);
        int[] intarr = {4, 9, 1, 7, 2, 5, 0, 2, 6};

        // sort List in ascending order
        List<Integer> li = listaa.stream().sorted().collect(Collectors.toList());
        System.out.println(li);

        listaa.stream().sorted().forEach(System.out::println);

        // sort List in descending order
        List<Integer> lis = listaa.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(lis);

        listaa.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // sort Array in ascending order
        List<Integer> liss = Arrays.stream(intarr).boxed().sorted().collect(Collectors.toList());
        System.out.println(liss);

        Arrays.stream(intarr).boxed().sorted().forEach(System.out::println);
        Arrays.stream(intarr).sorted().forEach(System.out::println);

        // sort Array in descending order
        List<Integer> lisss = Arrays.stream(intarr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(lisss);

        Arrays.stream(intarr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 15. anyMatch(), allMatch(), noneMatch()

        Set<Integer> set = new HashSet<Integer>();
        set.add(2);
        set.add(4);
        set.add(6);
        set.add(8);
        set.add(10);
        set.add(12);

        boolean result = set.stream().anyMatch(n -> {
            return n % 2 == 0;
        });
        System.out.println(result);

        result = set.stream().allMatch(n -> {
            return n % 2 == 0;
        });
        System.out.println(result);

        result = set.stream().noneMatch(n -> {
            return n % 2 == 0;
        });
        System.out.println(result);

        // 16. findAny() & findFirst()

        List<String> ll=Arrays.asList("Mahi", "Yuvi", "Bhuvi");
        List<String> emptyList=Arrays.asList();

        Optional<String> strr=ll.stream().findFirst();
        System.out.println(strr.get());   // Mahi

        Optional<String> strr1=ll.stream().findAny();
        System.out.println(strr1.get());  // Mahi

        Optional<String> strr2=emptyList.stream().findFirst();
        System.out.println(strr2.get());  // NoSuchElementException No value present
        System.out.println(strr2.isPresent());  // False

        Optional<String> str3=emptyList.stream().findAny();
        System.out.println(str3.get());  // NoSuchElementException No value present
        System.out.println(str3.isPresent());  // False

        // 17. Stream concatenating

        List<String> birds = Arrays.asList("Peacock", "Sparrow", "Parrot");
        List<String> animals = Arrays.asList("Bull", "Cow", "Buffallow");

        Stream<String> stream1 = birds.stream();
        Stream<String> stream2 = animals.stream();

        Stream.concat(stream1, stream2).forEach(System.out::println);
        List<String> streamList = Stream.concat(stream1, stream2).collect(Collectors.toList());
        System.out.println(streamList);

    }
}