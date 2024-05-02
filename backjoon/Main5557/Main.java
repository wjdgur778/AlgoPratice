//package backjoon.Main5557;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
///**
// * 백준 1학년
// * https://www.acmicpc.net/problem/5557
// * <p>
// * 상근이가 1학년 때, 덧셈, 뺄셈을 매우 좋아했다. 상근이는 숫자가 줄 지어있는 것을 보기만 하면, 마지막 두 숫자 사이에 '='을 넣고, 나머지 숫자 사이에는 '+' 또는 '-'를 넣어 등식을 만들며 놀고 있다. 예를 들어, "8 3 2 4 8 7 2 4 0 8 8"에서 등식 "8+3-2-4+8-7-2-4-0+8=8"을 만들 수 있다.
// * 상근이는 올바른 등식을 만들려고 한다. 상근이는 아직 학교에서 음수를 배우지 않았고, 20을 넘는 수는 모른다. 따라서, 왼쪽부터 계산할 때, 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다. 예를 들어, "8+3+2-4-8-7+2+4+0+8=8"은 올바른 등식이지만, 8+3+2-4-8-7이 음수이기 때문에, 상근이가 만들 수 없는 등식이다.
// * 숫자가 주어졌을 때, 상근이가 만들 수 있는 올바른 등식의 수를 구하는 프로그램을 작성하시오
// */
//
//public class Main {
//    static int N;
//    static int[] arr;
//    static long answer;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        solution(0,0);
//        System.out.println(answer);
//
//    }
//
//    public static void solution(int sum, int idx) {
//        if (idx == N - 1) {
//            if (sum == arr[idx]) answer++;
//            return;
//        }
//        if (sum < 0 || sum > 20) {
//            return;
//        }
//        solution(sum + arr[idx], idx + 1);
//        solution(sum - arr[idx], idx + 1);
//    }
//}

// _______________________________________________________________________________
package backjoon.Main5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1학년
 * https://www.acmicpc.net/problem/5557
 * <p>
 * 상근이가 1학년 때, 덧셈, 뺄셈을 매우 좋아했다. 상근이는 숫자가 줄 지어있는 것을 보기만 하면, 마지막 두 숫자 사이에 '='을 넣고, 나머지 숫자 사이에는 '+' 또는 '-'를 넣어 등식을 만들며 놀고 있다. 예를 들어, "8 3 2 4 8 7 2 4 0 8 8"에서 등식 "8+3-2-4+8-7-2-4-0+8=8"을 만들 수 있다.
 * 상근이는 올바른 등식을 만들려고 한다. 상근이는 아직 학교에서 음수를 배우지 않았고, 20을 넘는 수는 모른다. 따라서, 왼쪽부터 계산할 때, 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다. 예를 들어, "8+3+2-4-8-7+2+4+0+8=8"은 올바른 등식이지만, 8+3+2-4-8-7이 음수이기 때문에, 상근이가 만들 수 없는 등식이다.
 * 숫자가 주어졌을 때, 상근이가 만들 수 있는 올바른 등식의 수를 구하는 프로그램을 작성하시오
 */

public class Main {
    static int N;
    static int[] arr;
    static long[][] dp;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new long[N][21];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                dp[i][j]=0;
            }
        }
        solution();
    }
    public static void solution(){
        dp[0][arr[0]]=1;
        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j <=20 ; j++) {
                if(dp[i-1][j]>0){
                    if(j+arr[i]<=20){
                        dp[i][j+arr[i]]+=dp[i-1][j];
                    }
                    if(j-arr[i]>=0){
                        dp[i][j-arr[i]]+=dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[N-2][arr[N-1]]);
    }


}
