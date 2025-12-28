package backjoon.Main21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int max = 0;
        int num = 1;
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum =0;
        for (int i = 0; i < X; i++) {
           sum+= arr[i];
           max+= arr[i];
        }

        for (int i = 0; i <N-X ; i++) {
             sum = sum - arr[i] + arr[i+X];
            if(max<sum){
                max = sum;
                num = 1;
            }
            else if (max==sum) num++;

        }
        if(max==0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(num);
        }
    }
}
