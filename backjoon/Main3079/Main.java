package backjoon.Main3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;
    static long[] arr;
    static long maxvalue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
            maxvalue = Math.max(arr[i],maxvalue);
        }
        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long answer = Long.MAX_VALUE;
        long s = 1;
        long e = maxvalue*M;
        while (s <= e) {
            long mid = (s + e) / 2;
//            System.out.println(answer);
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid / arr[i];
            }
            if(sum<M){
                s = mid + 1;
            }
            else{
                answer = Math.min(answer,mid);
                e = mid - 1;
            }
        }
        return answer;
    }
}
