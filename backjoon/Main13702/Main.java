package backjoon.Main13702;

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
        long sum =0;
        // 어떤 양 x 로 나눴을때 정확히 K가 나와야한다.
        // 하지만 x가 최대가 되어야 함
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());;
            sum += arr[i];

        }
        long s = 0;
        long e = sum/K;
        long answer = 0;
        while(s<=e){
            long mid = (s+e)/2;
            if(mid==0)mid=1;
            int human = 0;
            for (int i = 0; i < N; i++) {
                human += arr[i]/mid;
            }
            // 0 1 2 3 4 5 6 7 8 9 10 11
            if(human < K){
                e = mid-1;
            }
            // 원하는 값이거나 그것보다 작을때
            else{
                s = mid+1;
                answer  = Math.max(answer,mid);
            }
        }
        System.out.println(answer);
    }

}
