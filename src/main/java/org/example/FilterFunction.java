package org.example;

import java.util.ArrayList;
import java.util.List;

class FilterFunctionTest {
    int id;
    String name;
    Double salary;

    FilterFunctionTest(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class FilterFunction {

    public static void main(String[] args) {
        List<FilterFunctionTest> list = new ArrayList<FilterFunctionTest>();
        list.add(new FilterFunctionTest(1, "Mahantesh", 20000.0));
        list.add(new FilterFunctionTest(2, "Mahi", 30000.0));
        list.add(new FilterFunctionTest(3, "Mantesh", 40000.0));
        list.add(new FilterFunctionTest(4, "Kiranagi", 50000.0));
        list.add(new FilterFunctionTest(5, "MDK", 60000.0));

        list.stream().filter(p -> p.salary > 40000).forEach(n -> System.out.println(n.id + " " + n.name + " " + n.salary));
    }
}