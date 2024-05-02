package backjoon.Main4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x,y;

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
    static Pair start;
    static boolean[][] m_check;
    static boolean[][] f_check;
    static Queue<Pair> mq = new LinkedList<>();
    static Queue<Pair> fq = new LinkedList<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        m_check = new boolean[N][M];
        f_check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'J') start = new Pair(i, j);
                if (arr[i][j] == 'F') {
                   fq.offer(new Pair(i,j));
                   f_check[i][j]=true;
                }
            }
        }
        if(move())System.out.println(answer+1);
        else System.out.println("IMPOSSIBLE");
    }

    static boolean move() {
        mq.offer(start);
        m_check[start.x][start.y] = true;
        while (!mq.isEmpty()) {
            int f_size = fq.size();
            for (int i = 0; i < f_size; i++) {
                Pair cur = fq.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) continue;
                    if (f_check[nx][ny]) continue;
                    if (arr[nx][ny] == '#') continue;
                    f_check[nx][ny] = true;
                    arr[nx][ny] = 'F';
                    fq.offer(new Pair(nx, ny));
                }
            }
            int m_size = mq.size();
            for (int i = 0; i < m_size; i++) {
                Pair cur = mq.poll();
                if(cur.x==0||cur.y==0||cur.x==N-1||cur.y==M-1)  return true;
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) continue;
                    if (m_check[nx][ny]) continue;
                    if (arr[nx][ny] == '#') continue;
                    if (arr[nx][ny] == 'F') continue;
                    m_check[nx][ny] = true;
                    mq.offer(new Pair(nx, ny));
                }
            }
            answer++;
        }
        return false;
    }
}
