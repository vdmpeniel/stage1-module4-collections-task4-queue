package com.epam.collections.queue;

import java.util.*;
import java.util.stream.Collectors;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        List<String> union = new ArrayList<>();
        union.addAll(firstList);
        union.addAll(secondList);

        PriorityQueue<String> result = new PriorityQueue<>(Comparator.reverseOrder());
        result.addAll(union);
        return result;
    }

    public static void main(String[] args) {
        PriorityQueueCreator pqc = new PriorityQueueCreator();
        System.out.println(
            pqc.createPriorityQueue(
                    List.of("The", "Java", "PriorityQueue", "class"),
                    List.of()
            )
        );
    }
}


