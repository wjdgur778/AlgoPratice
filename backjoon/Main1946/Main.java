package backjoon.Main1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T,N;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(arr, (ii, jj) -> Integer.compare(ii[0], jj[0]));
//            for (int[] a : arr) System.out.println(a[0]+" "+a[1]);
            int max = arr[0][1];
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (max > arr[j][1]) {
                    max = arr[j][1];
                    cnt++;
                }
            }
            System.out.println(cnt);

        }
    }

}
