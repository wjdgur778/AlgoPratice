package backjoon.Main21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum1 = new int[N];
        int[] sum2 = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        /*
            9 9 4 1 4 9 9
         */
        sum1[0]=arr[0];
        sum2[N-1]=arr[N-1];
        for (int i = 1; i < N; i++) {
            sum1[i]=sum1[i-1]+arr[i];
            sum2[N-1-i]=sum2[N-i]+arr[N-1-i];
        }
        int max = 0;
        for (int i = 1; i < N; i++) {
            int s1 = sum1[N-1]-arr[0]-arr[i] + sum1[N-1]-sum1[i];
            int s2 = sum2[0]-arr[N-1]-arr[N-1-i] + sum2[0]-sum2[N-1-i];
            if(max<s1){
                max = s1;
            }
            if(max<s2){
                max = s2;
            }
        }
        for (int i = 1; i < N-1; i++) {
            int s1 = sum1[i]-arr[0] + sum2[i]-arr[N-1];
            if(max<s1){
                max = s1;
            }
        }
//        for (int n : sum1) {
//            System.out.print(n+" ");
//        }
//        System.out.println();
//        for (int n : sum2) {
//            System.out.print(n+" ");
//        }
        System.out.println(max);
    }
}
