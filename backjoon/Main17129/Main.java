package backjoon.Main17129;

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
    static int m, n;
    static Pair start;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j] - '0';
                if (arr[i][j] == 2){
                    start = new Pair(i, j);
                }
            }
        }
        //logic
        int answer = move();
        if(answer==0)System.out.println("NIE");
        else {
            System.out.println("TAK");
            System.out.println(answer);
        }
    }

    static int move() {
        int cnt = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(start);
        check[start.x][start.y] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                if (arr[cur.x][cur.y] == 3 || arr[cur.x][cur.y] == 4 || arr[cur.x][cur.y] == 5) {
                    return cnt;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) continue;
                    if (check[nx][ny]) continue;
                    if (arr[nx][ny] == 1) continue;
                    check[nx][ny]=true;
                    q.offer(new Pair(nx, ny));
                }
            }
            cnt++;
        }
        return 0;
    }
}
