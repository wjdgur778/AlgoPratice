package backjoon.Main14945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dy = {0, 1};
    static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        move(0, 0, 0);
        System.out.println(cnt);

    }

    static void move(int x, int y, int idx) {
        arr[x][y] = -1;
        if (x == n - 1) {
            //dynamic logic
            cnt++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            move(x + 1, ny, idx);
        }
    }

}
