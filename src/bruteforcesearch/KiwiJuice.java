package bruteforcesearch;

import java.util.Arrays;

public class KiwiJuice {

    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int i = 0; i < fromId.length; i++) {
            int start = fromId[i];
            int end = toId[i];
            int remain = capacities[end] - bottles[end];

            if (remain >= bottles[start]) {
                bottles[end] += bottles[start];
                bottles[start] = 0;
            } else {
                bottles[end] += remain;
                bottles[start] -= remain;
            }
        }
        return bottles;
    }

    public static void main(String[] args) {

        int[] ints = new KiwiJuice().thePouring(
                new int[]{700000, 800000, 900000, 1000000},
                new int[]{478478, 478478, 478478, 478478},
                new int[]{2, 3, 2, 0, 1},
                new int[]{0, 1, 1, 3, 2});

        System.out.println(Arrays.toString(ints));
    }
}