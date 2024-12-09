package backjoon.Main1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r;
    static int c;
    static boolean f = true;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dividedAndConquer(0, 1 << N);
    }

    public static void dividedAndConquer(int sum, int n) {
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        if (r < n / 2 && c < n / 2) {
            dividedAndConquer(sum, n / 2);
        } else if (r < n / 2 && c >= n / 2) {
            c-=n/2;
            dividedAndConquer(sum + ((n / 2) * (n / 2)), n / 2);
        } else if (r >= n / 2 && c < n / 2) {
            r-=n/2;
            dividedAndConquer(sum + (2 * (n / 2) * (n / 2)), n / 2);

        } else {
            c-=n/2;
            r-=n/2;
            dividedAndConquer(sum + (3 * (n / 2) * (n / 2)), n / 2);
        }

    }
}
