package practice.LambdaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



public class LambdaStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        // Integer 데이터를 갖는 Stream 생성
        Stream<Integer> stream = list.stream();

        // forEach()를 사용해서 1 2 3 4 5 6 출력
        stream.forEach((Integer i) -> { System.out.println(i);
        });
    }
}
