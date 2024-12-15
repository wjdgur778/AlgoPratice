package backjoon.Main15810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static long N, M;
    static long answer;
    static ArrayList<Long> arr;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        //40 , 56, 24
        //
        for (int i = 0; i < N; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }

        solve();
        System.out.println(answer);

    }

    static void solve() {
        long s = 0;
        long e = 1000000L * 1000000;
        while (s <= e) {
            long sum = 0;
            long mid = (s + e) / 2;
            for (long n : arr) {
                sum += mid / n;
            }
            //시간을 줄여도됨
            if (M <= sum) {
                e = mid - 1;
                answer = mid;
            }
            //늘여야됨
            else if (M > sum) {
                s = mid + 1;
            }
        }
    }
}
