package calculator;

import java.util.List;

public class Adder {

    static public int add(List<Integer> array){
        int total=-0;
        for (Integer i : array) {
            total += i;
        }
        return total;
    }
}
