package backjoon.Main2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr[i] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[n][k]);
    }
}
