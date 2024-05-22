package backjoon.Main8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int L;
    static int[] shots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        shots = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            shots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shots);
        // 모두 확인하면서 잡히는지 확인하려면 시간초과
        // 동물은 for로 돌고 사대를 이분탐색으로 돌면서 그 동물이 잡힐지 잡히지 않을지 보면 될듯?
        // 사격 거리는 모두 일정하기때문에
        // 할 수 있을듯
        int cnt = 0 ;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = N - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                int dist = Math.abs(x - shots[mid]) + y;
                if (dist <= L) {
                    cnt++;
                    break;
                }
                if (x <= shots[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }

        }
        System.out.println(cnt);

    }
}
