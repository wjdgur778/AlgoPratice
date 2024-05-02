package backjoon.Main16943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 정수 A와 B가 있을 때, A에 포함된 숫자의 순서를 섞어서 새로운 수 C를 만들려고 한다. 즉, C는 A의 순열 중 하나가 되어야 한다.
 * 가능한 C 중에서 B보다 작으면서, 가장 큰 값을 구해보자. C는 0으로 시작하면 안 된다.
 * ex) 1234 3456 / 1000 5
 * <p>
 * 단순 순열 문제
 * 주의해야할 점은 "C는 0으로 시작하면 안된다"이다.
 */
public class Main {
    static char[] A;
    static boolean[] check;
    static int answer = -1;
    static int gap = Integer.MAX_VALUE;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());
        check = new boolean[A.length];
        permu("", 0);

        System.out.println(answer);

    }
//   1234  2452
    static void permu(String s, int cnt) {
        if (cnt == A.length) {
            if (s.charAt(0) == '0') return;
            int tmp = Integer.parseInt(s);
            if (B > tmp && gap > B - tmp) {
                gap = B - tmp;
                answer = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (check[i]) continue;
            check[i] = true;
            permu(s + A[i], cnt + 1);
            check[i] = false;
        }
    }
}
