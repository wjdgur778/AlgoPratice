package backjoon.Main21610;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Data {
    int x;
    int y;
    int w;

    Data(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Data> cloud;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cloud = new ArrayList<>();

        cloud.add(new Data(N - 1, 0, 0));
        cloud.add(new Data(N - 1, 1, 0));
        cloud.add(new Data(N - 2, 0, 0));
        cloud.add(new Data(N - 2, 1, 0));

        //인덱스 이동시에 벗어나는것은 없게 해야한다.


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            moveAndMagic(dir - 1, cnt);
        }
        calc();
    }

    static void moveAndMagic(int dir, int cnt) {
        ArrayList<Data> tmp = new ArrayList<>();
        ArrayList<Data> tmp2 = new ArrayList<>();
        int size = cloud.size();
        //이동
        for (int i = 0; i < size; i++) {
            Data cur = cloud.get(i);
            int nx = dx[dir] == 0 ? cur.x : (cur.x + ((dx[dir]) < 0 ? N - (cnt % N) : cnt)) % N;
            int ny = dy[dir] == 0 ? cur.y : (cur.y + ((dy[dir]) < 0 ? N - (cnt % N) : cnt)) % N;
            map[nx][ny]++;
            tmp.add(new Data(nx, ny, map[nx][ny]));
        }


        int t_size = tmp.size();
        //물복사
        for (int i = 0; i < size; i++) {
            Data cur = tmp.get(i);
            int sum = 0;
            for (int j = 1; j < 8; j += 2) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) continue;
                if(map[nx][ny]==0)continue;
                sum++;
            }
            sum += cur.w;
            tmp2.add(new Data(cur.x, cur.y, sum));
        }

        makeCloud(tmp2);

    }

    public static void makeCloud(ArrayList<Data> sums) {

        for (int i = 0; i < sums.size(); i++) {
            Data cur = sums.get(i);
            map[cur.x][cur.y] = 0;
        }
        cloud = new ArrayList<Data>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    map[i][j] -= 2;
                    cloud.add(new Data(i, j, 0));
                }
            }
        }

        for (int i = 0; i < sums.size(); i++) {
            Data cur = sums.get(i);
            map[cur.x][cur.y] = sums.get(i).w;
        }

    }
    static void calc(){
        int sum =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N ; j++) {
                sum+=map[i][j];
            }
        }
        System.out.println(sum);
    }
}
