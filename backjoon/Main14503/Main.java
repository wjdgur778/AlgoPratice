package backjoon.Main14503;

import javax.management.DynamicMBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int r, c, d;
    static boolean shutdown;
    static int answer = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //현재 방향에서 왼쪽 방향이라는것은
        // (d + (4-(cnt%4))%4
        arr[r][c] = 2;

        move(r, c);

        System.out.println(answer);
    }

    //  왼쪽으로 돌거di
//  현재 방향에서의 왼쪽으로 도는거기 때문에 왼쪽으로 가는것을 쭉 반복하는게 아니고
//    딱 현재 방향에서의 왼쪽만 생각 하면된다.
    //확인하다가 갈곳이 있응면 그쪽으로 가고 없으면 후진을 한다.
    //후진 까지 못하게 되면 shutdown
    public static void move(int x, int y) {
        //현재 위치 청소
        if (shutdown) return;
        //왼쪽으로 확인하면서 가능하면 들어가고 모든 방향이 불가능하면 후진,
        // 후진도 안되면 shutdown
        boolean f = true;
        for (int i = 1; i <= 4; i++) {
            int nx = x + dx[(d + (4 - (i % 4))) % 4];
            int ny = y + dy[(d + (4 - (i % 4))) % 4];
            if (!shutdown&&arr[nx][ny] == 0) {
                d = (d + (4 - (i % 4))) % 4;
                f = false;
                arr[nx][ny] = 2;
                answer++;
                move(nx, ny);
            }
        }
        //4방향 모두 못갔다면
        if (f) {
            if (arr[x + dx[(d + 2) % 4]][y + dy[(d + 2) % 4]] == 1) {
                shutdown = true;
                return;
            } else {
                move(x + dx[(d + 2) % 4], y + dy[(d + 2) % 4]);
            }
        }
    }
}
