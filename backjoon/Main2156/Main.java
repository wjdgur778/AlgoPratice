package backjoon.Main2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[2][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(answer);
    }
//  6 10 13 9 8 1 10 11 14

    /**
     * dp[n] = max(dp[n-3]+stair[n]+stair[n-1],dp[n-2]+stair[n], dp[n-1])
     */
    private static void solution() {

    }
}
