package backjoon.Main1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int W, H;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {1, 2, 2, 1,- 1, -2, -2, -1};
    static int[][] arr;

    static class Pair {
        int x;
        int y;
        int able;

        Pair(int x, int y,int able) {
            this.x = x;
            this.y = y;
            this.able = able;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int cnt = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        boolean[][][] check = new boolean[H][W][K+1];
        q.offer(new Pair(0, 0, 0));
        check[0][0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                if (cur.x == H - 1 && cur.y == W - 1) return cnt;
                if (cur.able<K) {
                    for (int j = 0; j < 8; j++) {
                        int nx = cur.x + hx[j];
                        int ny = cur.y + hy[j];
                        if (nx < 0 || ny < 0 || nx > H - 1 || ny > W - 1) continue;
                        if (check[nx][ny][cur.able+1]) continue;
                        if (arr[nx][ny] == 1) continue;
                        check[nx][ny][cur.able+1] = true;
                        q.offer(new Pair(nx, ny, cur.able+1));
                    }
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > H - 1 || ny > W - 1) continue;
                    if (check[nx][ny][cur.able]) continue;
                    if (arr[nx][ny] == 1) continue;
                    check[nx][ny][cur.able] = true;
                    q.offer(new Pair(nx, ny, cur.able));
                }
            }
            cnt++;
        }
        return -1;
    }
}
