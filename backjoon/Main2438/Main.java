package backjoon.Main2438;

import sun.awt.image.BufferedImageDevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        solve(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) System.out.print("*");
                else  System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void solve(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i %2==0&& j%2==0 ) continue;
                solve(x + (i * (n/3)), y + (j * (n/3)), n / 3);
            }
        }

    }
}
