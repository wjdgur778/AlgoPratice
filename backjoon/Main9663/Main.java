package backjoon.Main9663;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 */
class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;
    static int[] sum;
    static int[] sub;
    static int[] col;
    static LinkedList<Pair> list;
    static int answer;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new LinkedList<>();
        sum = new int[30];
        sub = new int[30];
        col = new int[N];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cur) {
        if (cur == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(sum[cur+i]==1||sub[cur-i+15]==1||col[cur]==1)continue;
            sum[cur+i]=1;sub[cur-i+15]=1;col[cur]=1;
            dfs(cur + 1);
            sum[cur+i]=0;sub[cur-i+15]=0;col[cur]=0;
        }
    }
}
