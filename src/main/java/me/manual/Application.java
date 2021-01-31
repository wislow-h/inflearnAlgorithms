package me.manual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AnnotationAttributes;

import java.util.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 8, 9};
        List<Integer> uniqueNumber = new ArrayList<>();

        //System.out.println("From List : " + findUniqueNumberFromList(numbers, uniqueNumber));
        //System.out.println("From Map : " + findUniqueNumberFromHashMap(numbers));
        //System.out.println("From Bit Calcuation : " + findUniqueNumberUsingBitCalculation(numbers));
        System.out.println(findUniqueNumberUsingBitCalculation(numbers));
    }

    // 시간복잡도 : O(n) -> O(n2)
    // 공간복잡도 : O(n)
    private static int findUniqueNumberFromList(int[] numbers, List<Integer> uniqueNumber) {

        for (int number : numbers){
            if (uniqueNumber.contains(number)) { // for loop -> O(n)
                uniqueNumber.remove((Integer) number);
            } else {
                uniqueNumber.add(number);
            }
        }

        if (uniqueNumber.size() > 1) {
            // log ERROR.
            return -1;
        }

        return uniqueNumber.get(0);
    }

    // HashMap을 사용하여, key - 숫자, value - 포함된 횟수 를 저장하여 횟수가 1인 key값을 return한다.
    // 시간복잡도 : O(n)
    // 공간복잡도 : O(n) -> hash map 의 크기가 파라미터 크기만큼 늘어나기 때문에.
    private static int findUniqueNumberFromHashMap(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            int count = Optional.ofNullable(map.get(number))
                                .map(it -> it + 1)
                                .orElse(1);

            map.put(number, count);
        }

        for (int number : numbers) {
            if (map.get(number) == 1) {
                return number;
            }
        }

        return -1;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : numbers) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for (int number : numbers) {
//            if (map.get(number) == 1) {
//                return number;
//            }
//        }
//
//        return -1;
    }

    private static int findUniqueNumberUsingBitCalculation(int[] numbers) {
        int uniqueNum = 0;

        for (int num : numbers) {
            uniqueNum ^= num;
        }

        return uniqueNum;
    }
}
