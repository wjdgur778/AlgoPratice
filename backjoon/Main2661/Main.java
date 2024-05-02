//package backjoon.Main2661;
//
//import java.util.Scanner;
//
///**
// * 숫자 1, 2, 3으로만 이루어지는 수열이 있다. 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면, 그 수열을 나쁜 수열이라고 부른다. 그렇지 않은 수열은 좋은 수열이다.
// * <p>
// * 다음은 나쁜 수열의 예이다.
// * <p>
// * 33
// * 32121323
// * 123123213
// * 다음은 좋은 수열의 예이다.
// * <p>
// * 2
// * 32
// * 32123
// * 1232123
// * 길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램을 작성하라. 예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수열은 1213121이다.
// */
//public class Main {
//    static int n;
//    static boolean f = true;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        solution(new StringBuilder(""), 0);
//    }
//
//    private static void solution(StringBuilder s, int cnt) {
//        if (cnt == n) {
//            f = false;
//            System.out.println(s.toString());
//            return;
//        }
//        for (int i = 1; i <= 3; i++) {
//            boolean check = true;
//            s.append(i);
//            for (int j = 1; j <= (cnt + 1) / 2; j++) {
//                if (s.toString().substring(cnt - (2 * j) + 1, cnt - j + 1).equals(s.toString().substring(cnt - j + 1, cnt + 1))) {
//                    check = false;
//                }
//            }
//            if (check) {
//                if (f) {
//                    solution(s, cnt + 1);
//                    s.deleteCharAt(s.length() - 1);
//                }
//            } else {
//                s.deleteCharAt(s.length() - 1);
//            }
//        }
//
//    }
//}
package backjoon.Main2661;

import java.util.Scanner;

/**
 * 숫자 1, 2, 3으로만 이루어지는 수열이 있다. 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면, 그 수열을 나쁜 수열이라고 부른다. 그렇지 않은 수열은 좋은 수열이다.
 * <p>
 * 다음은 나쁜 수열의 예이다.
 * <p>
 * 33
 * 32121323
 * 123123213
 * 다음은 좋은 수열의 예이다.
 * <p>
 * 2
 * 32
 * 32123
 * 1232123
 * 길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램을 작성하라. 예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수열은 1213121이다.
 */
public class Main {
    static int n;
    static boolean f = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solution(new StringBuilder(""), 0);
    }

    private static void solution(StringBuilder s, int cnt) {
        if (cnt == n) {
            f = false;
            System.out.println(s.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            boolean check = true;
            s.append(i);
            for (int j = 1; j <= (cnt + 1) / 2; j++) {
                if (s.toString().substring(cnt - (2 * j) + 1, cnt - j + 1).equals(s.toString().substring(cnt - j + 1, cnt + 1))) {
                    check = false;
                }
            }
            if (check) {
                if (f) {
                    solution(s, cnt + 1);
                    s.deleteCharAt(s.length() - 1);
                }
            } else {
                s.deleteCharAt(s.length() - 1);
            }
        }

    }
}
