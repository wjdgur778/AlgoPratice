package backjoon.Main17276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, n, d;
    static int[][] arr;
    static int[] tarr;
    static int cnt;
    //false : 반시계 , true : 시계
    static boolean dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int ii = 0; ii < T; ii++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            tarr = new int[n];
            //방향 설정
            dir = d < 0 ? false : true;
            cnt = Math.abs(d) / 45;
            if (cnt > 4) {
                cnt = 8 - cnt;
                dir = !dir;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < cnt; i++) spin();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void spin() {
        for (int i = 0; i < n; i++) tarr[i] = arr[i][(n - 1) / 2];
        if (dir) {
            for (int i = 0; i < n; i++) {
                arr[i][(n - 1) / 2] = arr[i][i];
                arr[i][i] = arr[(n - 1) / 2][i];
                arr[(n - 1) / 2][i] = arr[n - 1 - i][i];
                arr[n - 1 - i][i] = tarr[n-1-i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                arr[i][(n - 1) / 2] = arr[i][n - 1 - i];
                arr[i][n - 1 - i] = arr[(n - 1) / 2][n-1-i];
                arr[(n - 1) / 2][n-1-i] = arr[n-1-i][n-1-i];
                arr[n-1-i][n-1-i] = tarr[n-1-i];
            }
        }

    }

}
