package backjoon.Main2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[] arr;
    static String ans_min=String.valueOf(Long.MAX_VALUE);
    static String ans_max=String.valueOf(Long.MIN_VALUE);
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        check = new boolean[10];
        for (int i = 0; i < 10; i++) {
            check[i]=true;
            solve(String.valueOf(i), String.valueOf(i), 0);
            check[i]=false;
        }

        System.out.println(ans_max);
        System.out.println(ans_min);
    }

    private static void solve(String cur, String ans, int idx) {
        if (N == idx) {
            long sum = Long.parseLong(ans);
            long min = Long.parseLong(ans_min);
            long max = Long.parseLong(ans_max);
            ans_min = min > sum ? ans : ans_min;
            ans_max = max < sum ? ans : ans_max;
            return;
        }

        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(cur);
            if(check[i])continue;
            if ("<".equals(arr[idx]) && a < i) {
                check[i]=true;
                solve(String.valueOf(i), ans+i, idx + 1);
                check[i]=false;
            }
            else if (">".equals(arr[idx]) && a > i) {
                check[i]=true;
                solve(String.valueOf(i), ans + i, idx + 1);
                check[i]=false;
            }
        }
    }
}
