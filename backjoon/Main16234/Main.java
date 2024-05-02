package backjoon.Main16234;

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
    static int N, L, R;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] check;
    static boolean able;
    static int answer;
    static int size;
    static int sum;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            check = new boolean[N][N];
            able = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) continue;
                    size = 0;
                    sum = 0;
                    bfs(i, j);
                }
            }

            if (able) answer++;
            else {
                System.out.println(answer);
                break;
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        Queue<Pair> init_q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));
        check[x][y] = true;


        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Pair cur = q.poll();
                x = cur.x;
                y = cur.y;
                sum += arr[x][y];
                size++;
                init_q.offer(cur);
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
                    if (check[nx][ny]) continue;
                    if (Math.abs(arr[nx][ny] - arr[x][y]) >= L && Math.abs(arr[nx][ny] - arr[x][y]) <= R) {
                        able = true;
                        check[nx][ny] = true;
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }
        while (!init_q.isEmpty()) {
            Pair tmp = init_q.poll();
            arr[tmp.x][tmp.y] = sum / size;
        }
    }

    public static void init(int x, int y) {
        arr[x][y] = sum / size;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
            if (check[nx][ny]) init(nx, ny);
        }
    }
}
