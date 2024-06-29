package backjoon.Main21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[(N * N) + 1];
        int[][] map = new int[N][N];
        //처음은 (n/2,n/2)
            /*
                처음은 (n by n)
                0 by 0 부터 보면 어느곳이 좋아하는 친구가 있는 곳인지 모르잔항
             */
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            arr[idx] = tmp;
            if (i == 0) {
                map[1][1] = idx;
                continue;
            }
            int like_max = 0;
            ArrayList<Pair> likes = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int like_cnt = 0;

                    if (map[j][k] != 0) continue;
                    for (int l = 0; l < 4; l++) {
                        int nx = j + dx[l];
                        int ny = k + dy[l];
                        if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;

                        for (int num : tmp) {
                            if (map[nx][ny] == num) like_cnt++;
                        }
                    }
                    if (like_max < like_cnt) {
                        likes = new ArrayList<>();
                        likes.add(new Pair(j, k));
                        like_max = like_cnt;
                    } else if (like_max == like_cnt)
                        likes.add(new Pair(j, k));
                }
            }
            //다 돌면 likes에 좋아하는 사람이 많은 칸이 쌓여있다
            //한개도 없을순 없다
            //한개면 거기서 자리배정
            //여러개면 그중에서 주변에 빈곳이 많은 곳 -> 많았던 곳
            if (likes.size() == 1) map[likes.get(0).x][likes.get(0).y] = idx;
            else {
                int blank_max = 0;
                Pair assign = null;
                for (Pair cur : likes) {
                    int blank_cnt = 0;
                    for (int j = 0; j < 4; j++) {
                        int nx = cur.x + dx[j];
                        int ny = cur.y + dy[j];
                        if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
                        if (map[nx][ny] == 0) blank_cnt++;
                    }
                    if (blank_max < blank_cnt) {
                        blank_max = blank_cnt;
                        assign = new Pair(cur.x, cur.y);
                    }
                }
                if (assign == null) map[likes.get(0).x][likes.get(0).y] = idx;
                else map[assign.x][assign.y] = idx;
            }

        }
        int answer =0;
        for (int ii = 0; ii < N; ii++) {
            for (int jj = 0; jj < N; jj++) {
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = ii + dx[i];
                    int ny = jj + dy[i];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
                    for (int n : arr[map[ii][jj]]) {
                        if (n == map[nx][ny]) cnt++;
                    }
                }
                if(cnt==0)answer+=0;
                else if(cnt==1)answer+=1;
                else if (cnt==2)answer+=10;
                else if(cnt==3)answer+=100;
                else answer +=1000;
            }//10 10 1 10 100 10 1 1 1
        }
        System.out.println(answer);
    }
}
