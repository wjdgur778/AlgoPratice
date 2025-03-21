package backjoon.Main12908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Data {
        long sx;
        long sy;
        long ex;
        long ey;

        Data(long sx, long sy, long ex, long ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
    }

    static long ans = Long.MAX_VALUE;
    static long sx, sy;
    static long ex, ey;
    static boolean[] check;
    static long[][] arr;
    static ArrayList<Data> list;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        arr = new long[6][4];
        check = new boolean[6];
        for (int i = 0; i < 6; i+=2) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());

            arr[i+1][2] = arr[i][0];
            arr[i+1][3] = arr[i][1];
            arr[i+1][0] =  arr[i][2];
            arr[i+1][1] =  arr[i][3];
        }

        /**
         * 1.바로
         * 2.1개만 들리기
         * 3.2개 들리기
         * 4.3개 들리기
         * (순열임)
         */
        ans = calc(sx,sy,ex,ey);
        permu(0, 0);
        System.out.println(ans);
    }

    static void permu(int idx, int cnt) {
        count++;
        if (!list.isEmpty()) {
            long tmp = 0;
            long x1 = sx, y1 = sy;
            for (Data data : list) {
                tmp += calc(x1, y1, data.sx, data.sy);
                x1 = data.ex;
                y1 = data.ey;
                tmp += 10;
            }
            tmp += calc(x1, y1, ex, ey);
            ans = Math.min(ans, tmp);
        }
        if (cnt == 3) return;

        for (int i = 0; i < 6; i++) {
            if (check[i]) continue;
            list.add(new Data(arr[i][0], arr[i][1], arr[i][2], arr[i][3]));
            check[i] = true;
            permu(i + 1, cnt + 1);
            list.remove(cnt);
            check[i] = false;
        }

    }

    static long calc(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
