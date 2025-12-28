package backjoon.Main22251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] digits = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {0, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {0, 0, 0, 2, 5, 4, 3, 4, 2, 3},
            {0, 0, 0, 0, 3, 2, 3, 2, 2, 1},
            {0, 0, 0, 0, 0, 3, 4, 3, 3, 2},
            {0, 0, 0, 0, 0, 0, 1, 4, 2, 1},
            {0, 0, 0, 0, 0, 0, 0, 5, 1, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        //총 층수
        int N = Integer.parseInt(st.nextToken());
        //자리 수
        int K = Integer.parseInt(st.nextToken());
        //반전시킬 최대 갯수
        int P = Integer.parseInt(st.nextToken());
        //현재 층수
        StringBuilder X = new StringBuilder(st.nextToken());
        int size = K - X.length();
        for (int i = 0; i < size; i++) {
            X.insert(0, "0");
        }
        for (int i = 1; i <= N; i++) {
            StringBuilder cur = new StringBuilder(String.valueOf(i));
            size = K - cur.length();

            for (int ii = 0; ii < size; ii++) {
                cur.insert(0, "0");
            }
            if (cur.toString().equals(X.toString())) continue;
            if (check(X.toString(), cur.toString(), P)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean check(String from, String to, int P) {
//        ex) 19235 -> 04349
        int f_size = from.length();
        int t_size = to.length();
        int num = 0;
        for (int i = 0; i <f_size; i++) {
            int to_num = to.charAt(i) - '0';
            int from_num = from.charAt(i) - '0';
            num += digits[to_num][from_num] == 0 ? digits[from_num][to_num] : digits[to_num][from_num];
        }
        return P >= num;
    }
}
