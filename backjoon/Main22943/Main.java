package backjoon.Main22943;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int K, M;
    static int number = 98765;
    static int[] arr = new int[100000];
    static List<Integer> list;
    static boolean check[];
    static boolean check_one[];
    static boolean check_two[];

    static int answer;
    static List<Integer> nums;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        nums = new ArrayList<>();
        check = new boolean[10];
        check_one = new boolean[100002];
        check_two = new boolean[100002];
        //98765까지 소수만들기 (에라토스테네스의 체)
        //아닌것이 1
        for (int i = 2; i <= number; i++) {
            if (arr[i] == 1) continue;
            list.add(i);
            for (int j = i * 2; j <= number; j += i) {
                arr[j] = 1;
            }
        }
        able_one();
        able_two();
        permutaion(0, new StringBuilder());
        System.out.println(answer);
    }

    public static void permutaion(int cnt, StringBuilder s) {
        if (cnt == K) {
            int a = Integer.parseInt(s.toString());
            if (check_one[a]) {
                while (true) {
                    if (a < M) break;
                    a = a / M;
                }
                if (check_two[a]) answer++;
            }

            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (check[i]) continue;
            s.append(i);
            check[i] = true;
            permutaion(cnt + 1, s);
            check[i] = false;
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void able_one() {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) > 100000) break;
                check_one[list.get(i) + list.get(j)] = true;
            }
        }
    }

    public static void able_two() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if ((long)(list.get(i) * list.get(j) )< 100000) {
                    System.out.println((long) (list.get(i) * list.get(j)));
                    check_two[(int) (list.get(i) * list.get(j))] = true;
                }      }
        }
    }

}
