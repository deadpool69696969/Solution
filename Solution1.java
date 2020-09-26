
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        Integer array[] = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
       // Integer array[] = {0, 2, 3, 4, 5, 6};
         //  Integer array[] = {1, 11, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        int result[] = giveMeResult(array);
        System.out.println(result[0] + " - " + result[1]);
    }

    private static int[] giveMeResult(Integer[] getArray) {
        int start = 0;
        int end = 0;

        int[] array = fixArray(getArray);

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                start = array[0];
                end = array[0];
            } else {
                if (array[i] >= end) {
                    end = array[i];
                }
                if (array[i] <= start) {
                    start = array[i];
                }

            }

        }
        int result[] = {start, end};
        return result;
    }

    private static int[] fixArray(Integer[] array) {
        List<Integer> finalArray = new ArrayList<>();
        Collections.addAll(finalArray, array);

        int min = 0;
        int max = 0;

        for (int i = 0; i < finalArray.size(); i++) {

            if (i == 0) {
                min = finalArray.get(i);
                max = finalArray.get(i);
            }
            if (finalArray.get(i) >= max) {
                max = finalArray.get(i);
            }
            if (finalArray.get(i) <= min) {
                min = finalArray.get(i);
            }

        }
        boolean cal = false;
        outer:
        while (true) {
            cal = false;
            boolean exists = false;
            if (min == max) {
                break outer;

            } else {

                if (finalArray.contains(min + 1)) {
                } else {
                    finalArray.remove((Integer) min);
                    cal = true;
                }
                if (finalArray.contains(max - 1)) {
                } else {
                    finalArray.remove((Integer) max);
                    cal = true;
                }
                if (min == max) {
                    break outer;
                }

            }
            if (cal) {
                for (int i = 0; i < finalArray.size(); i++) {

                    if (i == 0) {
                        min = finalArray.get(i);
                        max = finalArray.get(i);
                    }
                    if (finalArray.get(i) >= max) {
                        max = finalArray.get(i);
                    }
                    if (finalArray.get(i) <= min) {
                        min = finalArray.get(i);
                    }

                }
            } else {
                if (min == max) {
                    break outer;
                }
                min = min + 1;
                if (min == max) {
                    break outer;
                }
                max = max - 1;
                if (min == max) {
                    break outer;
                }
            }

        }
        int returnArray[] = new int[finalArray.size()];
        int i = 0;
        for (int arr : finalArray) {
            returnArray[i] = arr;
            i++;
        }
        return returnArray;

    }
}
