package backjoon.Main2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int s, e;
    static int[] arr;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        //login
        logic();
    }
    //이분탐색 -> 시작점 , 끝점 ?? -> 인덱스 or 실제 숫자
    static void logic() {
        int s =0 ;
        int e =1000000000;
        int answer =0 ;
        while(s<=e){
            int mid = (s+e)/2;
            long sum=0;
            for (int i = 0; i < N; i++) {
                if(arr[i]>=mid)sum+=arr[i]-mid;
            }
            if(sum<M){
                e = mid-1;
            }
            else{
                s = mid+1;
                answer =mid;
            }
        }
        System.out.println(answer);
    }
}
