package backjoon.Main2157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //1 to N 까지 M개 이하만 지나게 한다.
        //N(1 ≤ N ≤ 300), M(2 ≤ M ≤ N), K(1 ≤ K ≤ 100,000
        // 1->2->3 보다 1->3이 더 클 수 있다
        // 이건 어찌 아는가?
        // 기록해야한다.
        /*
             4 3
             3 2
             2 1
             1 3
             단방향 이다.
             1->3 -> 5 ->6 lose
             1->5 -> 6 lose
             1-> 6    win
         */
    }
}
