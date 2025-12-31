package backjoon.Main20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int tmp = 0;
        int s = 0;
        int e = 0;
        while (e < N) {
            if (cnt[arr[e]] < K) {
                cnt[arr[e]]++;
                e++;
                tmp++;
                answer = Math.max(answer, tmp);
            } else {
                tmp-- ;
                --cnt[arr[s]];
                s++;
            }
        }
        System.out.println(answer);
    }
}
