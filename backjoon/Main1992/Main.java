package backjoon.Main1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] arr;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        solution(0, 0, N);
    }

    private static void solution(int x, int y, int n) {

        if (n == 0) return;
        int check = check(x, y, n);
        if (check == '2') {
//      1,2,3,4분면 순서대로
            System.out.print("(");
            solution(x, y, n / 2);
            solution(x, y + (n / 2), n / 2);
            solution(x + (n / 2), y, n / 2);
            solution(x + (n / 2), y + (n / 2), n / 2);
            System.out.print(")");
        } else System.out.print((char)check);
    }

    private static char check(int x, int y, int n) {
        char cmp = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != cmp) {
                    return '2';
                }
            }
        }
        return cmp;
    }
}
