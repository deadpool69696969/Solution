
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    /*
   Question 1 ) Write a function that takes in an array of integers and returns an array of
length 2 representing the largest range of integers contained in that array.
The first number in the output array should be the first number in the range,
while the second number should be the last number in the range.
A range of numbers is defined as a set of numbers that come right after each
other in the set of real integers. For instance, the output array [2, 6]
represents the range {2, 3, 4, 5, 6}, which is a range of length 5. Note that
numbers don't need to be sorted or adjacent in the input array in order to
form a range.

You can assume that there will only be one largest range.

Sample Input
array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]

Sample Output
[0, 7]

    */

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
