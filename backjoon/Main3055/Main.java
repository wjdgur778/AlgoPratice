package backjoon.Main3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static char[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Pair> W = new LinkedList<>();
    static Queue<Pair> S = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'S') S.offer(new Pair(i, j));
                if (arr[i][j] == '*') W.offer(new Pair(i, j));
            }
        }
        solution();
    }

    private static void solution() {
        int count = 1;

        while (!S.isEmpty()) {
//          물
            if (!W.isEmpty()) {
                int W_size = W.size();
                for (int i = 0; i < W_size; i++) {
                    Pair cur = W.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = cur.x + dx[j];
                        int ny = cur.y + dy[j];
                        if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) continue;
                        if (arr[nx][ny] == 'X') continue;
                        if (arr[nx][ny] == '*') continue;
                        if (arr[nx][ny] == 'D') continue;
                        W.offer(new Pair(nx, ny));
                        arr[nx][ny] = '*';
                    }
                }
            }
//          고슴도치
            int S_size = S.size();
            for (int i = 0; i < S_size; i++) {
                Pair cur = S.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) continue;
                    if (arr[nx][ny] == 'X') continue;
                    if (arr[nx][ny] == '*') continue;
                    if (arr[nx][ny] == 'S') continue;
                    if (arr[nx][ny] == 'D') {
                        System.out.println(count);
                        return;
                    }
                    S.offer(new Pair(nx, ny));
                    arr[nx][ny] = 'S';
                }
            }
            count++;
        }
        System.out.println("KAKTUS");
        return;
    }

}
