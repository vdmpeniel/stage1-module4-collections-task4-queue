package com.epam.collections.queue;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> combined = new ArrayDeque<>();

        // initial turns
        takeTurn(combined, firstQueue, true);
        takeTurn(combined, secondQueue, true);

        do {
            takeTurn(combined, firstQueue, false);
            takeTurn(combined, secondQueue, false);
        } while (!firstQueue.isEmpty());

        // Reverse the order of elements
        return reverse(combined);
    }

    private ArrayDeque<Integer> reverse(ArrayDeque<Integer> queue){
        ArrayDeque<Integer> reversedQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            reversedQueue.add(queue.pollLast());
        }
        return reversedQueue;
    }

    private void takeTurn(ArrayDeque<Integer> combined, Queue<Integer> queue, boolean isInitialTurn){

        if (!isInitialTurn){
            ((Deque<Integer>) queue).addLast(combined.pollFirst());
        }
        IntStream.rangeClosed(1, 2).forEach(i -> {
            if (!queue.isEmpty()){
                combined.addFirst(((Deque<Integer>) queue).pollFirst());
            }
        });
    }

    public static void main(String[] args) {
        ArrayDequeCreator adc = new ArrayDequeCreator();
        System.out.println(
            adc.createArrayDeque(
                    new LinkedList<>(List.of(1, 4)),
                    new LinkedList<>(List.of(5, 6))
            )
        );
    }
}
