package backjoon.Main2194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, A, B, K;
    static Pair start;
    static Pair end;
    static int[][] arr;
    static boolean[][] visit;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int answer;
    static boolean f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a - 1][b - 1] = -1;
        }
        //start & end
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        start = new Pair(a - 1, b - 1);

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        end = new Pair(a - 1, b - 1);

        //항상 유닛의 크기를 생각하자
        bfs();
        if(!f)System.out.println(-1);
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start.x, start.y));
        arr[start.x][start.y]=1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                if(cur.x== end.x&&cur.y==end.y) {
                    System.out.println(answer);
                    f=true;
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx <= N - A && ny <= M - B) {
                        if (arr[nx][ny] == 1 ||arr[nx][ny] == -1 ) continue;
                        if (check(nx, ny)) continue;
                        arr[nx][ny] = 1;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
            answer++;
        }
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (arr[x+i][y+j] == -1) return true;
            }
        }
        return false;
    }
}
