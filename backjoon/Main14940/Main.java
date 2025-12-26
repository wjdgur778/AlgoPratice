package backjoon.Main14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Data {
        int x;
        int y;

        Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Data start = null;
        int[][] map = new int[N][M];

        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) start = new Data(i, j);
                if (map[i][j] == 0) result[i][j] = 0;
            }
        }
        bfs(start, map);

    }

    static void bfs(Data start, int[][] map) {
        boolean[][] visit = new boolean[N][M];

        int dist = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Data> q = new LinkedList<>();
        q.offer(start);
        visit[start.x][start.y] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Data cur = q.poll();
                result[cur.x][cur.y] = dist;
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) continue;
                    if (map[nx][ny] == 0) {
                        continue;
                    }
                    if (visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    q.offer(new Data(nx, ny));
                }
            }
            dist++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j]);
                if (j != M - 1) System.out.print(" ");
            }

            if (i != N - 1) System.out.println();
        }
    }
}
