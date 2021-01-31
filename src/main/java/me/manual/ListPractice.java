package me.manual;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ListPractice {
    public static void main(String[] args) {
        int numbers1[] = {0,1,2,3,4,5};
        int[] numbers2 = {0,1,2,3,4,4,5};

        ListPractice practice = new ListPractice();

        //System.out.println(practice.hasDuplicatedElement(numbers2));
        //System.out.println(practice.hasDuplicatedElementInRandomArray(numbers1));
        System.out.println(practice.hasDuplicatedElementFeaturedBySet(numbers2));
    }

    // check if the sorted list has duplicated numbers
    // 시간복잡도 : O(n2)
    // 공간복잡도 : O(1)
    private boolean hasDuplicatedElement(int[] numbers) {
        for (int i = 0 ; i < numbers.length ; i++) {
            for (int j = i+1 ; j < numbers.length ; j++) {
                if (i == j) {
                    return true;
                }
            }
        }

        return false;
    }

    // sorting 되어있지 않은 리스트는 sort를 먼저 해주는게 유리.
    // 시간복잡도 : O(NlogN)
    // 공간복잡도 : O(logN)
    private boolean hasDuplicatedElementInRandomArray(int[] numbers) {
        Arrays.sort(numbers); //Quicksort를 사용. 시간복잡도 O(NlogN), 공간복잡도 O(logN)

        for (int i = 0 ; i < numbers.length - 1 ; i++) {
            if (numbers[i] == numbers[i+1]) {
                return true;
            }
        }

        return false;
    }

    // 시간복잡도를 줄이고, 공간복잡도를 더 늘리는(트레이트오프...) 방법 : Set 을 써보쟈!!!
    // Set 의 contains는 List.contains와 달리, 시간복잡도가 O(1)이다.
    // 시간복잡도 : O(n)
    // 공간복잡도 : O(n)
    private boolean hasDuplicatedElementFeaturedBySet(int[] numbers) {
        Set<Integer> uniqueNumberSet = new HashSet<>();
        for (int num : numbers) {
            if (uniqueNumberSet.contains(num)) {
                return true;
            }
            uniqueNumberSet.add(num);
        }

        return false;
    }

}
