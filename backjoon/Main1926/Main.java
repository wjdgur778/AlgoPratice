package backjoon.Main1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count;
    static int local_cnt;
    static int answer;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                count++;
                arr[i][j] = 0;
                drawing(i, j);
                answer = answer < local_cnt ? local_cnt : answer;
                local_cnt=0;
            }
        }
        System.out.println(count);
        System.out.println(answer);
    }

    public static void drawing(int x, int y) {
        local_cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) continue;
            if (arr[nx][ny] == 0) continue;
            arr[nx][ny] = 0;
            drawing(nx, ny);
        }
    }
}
