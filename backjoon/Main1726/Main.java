package backjoon.Main1726;

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
        int cnt;
        int dir;

        Data(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    static int N;
    static int M;
    static int[][] map;
    static int[][] check;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Data start = new Data(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, Integer.parseInt(st.nextToken()) - 1);
        st = new StringTokenizer(br.readLine());
        Data end = new Data(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, Integer.parseInt(st.nextToken()) - 1);
//
        move_robot(start, end);
        System.out.println(answer);

    }

    public static void move_robot(Data start, Data end) {
        //0  1  2  3
        //동 서  남 북
        //해당지역을 최소로 온경우가 있으면 안가는걸로 해야하나?
        //그냥 체크하면?
        //직진을 할때 1or2or3 만큼을 갈수있네?
        //->
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Data> q = new LinkedList<Data>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(check[i], -1);
        }
        check[start.x][start.y] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Data cur = q.poll();
//                System.out.println(cur.x+" " + cur.y + " " +cur.cnt+" "+ cur.dir);
                //도착하면 방향만 바꿔서 최소값 구해
                if (cur.x == end.x && cur.y == end.y) {
                    int num =0 ;
                    if (cur.dir != end.dir) {
                        if (cur.dir % 2 == 0) {
                            num= end.dir - cur.dir == 1 ? 2 : 1;
                        } else {
                            num= cur.dir - end.dir == 1 ? 2 : 1;
                        }
                    }
                    //여기 포인트가 중요했다..
                    //방향을 바꾸는 과정까지 포함한 최솟값이 들어가야 한다.
                    //그래야 마지막에 방항때문에 생기는 최솟값 오류가 발생하지 않는다.
                    answer = Math.min(cur.cnt+num,answer);
                    check[cur.x][cur.y]=answer;
                    continue;
                }
                //현재 상태에 따라 해당 방향으로 가기 위한 회전 수까지 cnt에 포함
                for (int j = 0; j < 4; j++) {
                    //k가 1 ~ 3까지 가능한지 확인
                    //가능한 순간은 offer
                    int nx = cur.x;
                    int ny = cur.y;
                    int ncnt = cur.cnt + 1;
                    //방향 설정(해당 방향으로 갈수있게 설정)
                    if (cur.dir != j) {
                        if (cur.dir % 2 == 0) {
                            ncnt = j - cur.dir == 1 ? ncnt + 2 : ncnt + 1;
                        } else {
                            ncnt = cur.dir - j == 1 ? ncnt + 2 : ncnt + 1;
                        }
                    }
                    //3가지 경우로 직진 가능, 단 이미 나보다 빠르게 도착할수 있는 경우라면 그곳에 가지않음
                    for (int k = 1; k <= 3; k++) {
                        nx += dx[j];
                        ny += dy[j];
                        if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) break;
                        if (map[nx][ny] == 1) break;
                        if (check[nx][ny] == -1 || check[nx][ny] > ncnt) {
                            q.offer(new Data(nx, ny, ncnt, j));
                            check[nx][ny] = ncnt;
                        }
                    }
                }
            }
        }

    }
}
