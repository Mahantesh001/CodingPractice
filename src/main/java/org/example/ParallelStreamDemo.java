package org.example;

import java.util.Arrays;
import java.util.List;

class ParallelStream {
    String name;
    int score;

    ParallelStream(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}

public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<ParallelStream> list = Arrays.asList(
                new ParallelStream("Mahi", 90),
                new ParallelStream("Yuvi", 85),
                new ParallelStream("Bhuvi", 80),
                new ParallelStream("Yuzi", 87)
        );

        // Sequential stream()
        list.stream()
                .filter(i -> i.getScore() >= 85)
                .limit(3)
                .forEach(n -> System.out.println(n.getName() + " " + n.getScore()));

        // Parallel Stream ->  parallelStream()
        list.parallelStream()
                .filter(i -> i.getScore() >= 85)
                .limit(3)
                .forEach(n -> System.out.println(n.getName() + " " + n.getScore()));

        // Parallel Stream ->  stream().parallel()
        list.stream()
                .parallel()
                .filter(i -> i.getScore() >= 85)
                .limit(3)
                .forEach(n -> System.out.println(n.getName() + " " + n.getScore()));

        // Parallel Stream ordered ->  parallelStream() & forEachOrdered()
        list.parallelStream()
                .filter(i -> i.getScore() >= 85)
                .limit(3)
                .forEachOrdered(n -> System.out.println(n.getName() + " " + n.getScore()));

    }
}
