package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {

        ArrayList<Integer> result = new ArrayList<>();
        if (everyDishNumberToEat > numberOfDishes){ return result; }

        ArrayList<Integer> roundTable = (ArrayList<Integer>) IntStream.rangeClosed(1, numberOfDishes).boxed().collect(Collectors.toList());

        int i = everyDishNumberToEat - 1;
        while(!roundTable.isEmpty()){
            result.add(roundTable.get(i));
            roundTable.remove(i);
            i += everyDishNumberToEat - 1;

            while(i > roundTable.size() - 1 && !roundTable.isEmpty()){
                i -= roundTable.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DishOrderDeterminer dod = new DishOrderDeterminer();
        System.out.println(
            dod.determineDishOrder(10,3)
        );
    }
}
