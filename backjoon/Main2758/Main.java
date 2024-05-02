package backjoon.Main2758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 이렇게 열심히 로또를 하는데, 아직까지 한 번도 당첨되지 않은 이유는 수를 고를 때 각 숫자는 이전에 고른 수보다 적어도 2배가 되도록 고르기 때문이다.
 *
 * 예를 들어, n=4, m=10일 때, 선영이는 다음과 같이 고를 수 있다.
 *
 * 1 2 4 8
 * 1 2 4 9
 * 1 2 4 10
 * 1 2 5 10
 *
 */
public class Main {
    static int T,n,m;
    static int[] arr;
    static long[][] dp;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            answer=0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dp= new long[n+1][m+1];
            solution();
            for (int j = n; j <=m ; j++) {
                answer+=dp[n][j];
            }
//            for (int j = 1; j <=n ; j++) {
//                for (int k = 1; k <= m; k++) {
//                    System.out.print(dp[j][k]);
//                }
//                System.out.println();
//            }
            System.out.println(answer);
        }
    }
//  m개 중에 n개 뽑기 -> 조합이지만 조건(이전에 골랐던 것보다 2배 이상이어야 함)이 있다.
//  결국 다 세면 안됨
//  dp이거나 계산(수학)으로 해결해야 할듯
//  dp[x][y] x번째 자리에 y가 오는 경우의수
    private static void solution() {
        for (int i = 1; i <= m/(1<<(n-1)); i++) {
            dp[1][i]= 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1<<(i-1); j <= m/(1<<(n-i)); j++) {
                for (int k = 1<<(i-2); k <=j/2 ; k++) {
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }
    }
}
