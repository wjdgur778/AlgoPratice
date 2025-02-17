package backjoon.Main19939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int sum=0;
        for (int i = 1; i <=k ; i++) {
            sum+=i;
        }

        n-=sum;
        if(n<0) System.out.println(-1);
        else{
            if(n%k==0){
                System.out.println(k-1);
            }else{
                System.out.println(k);
            }
        }

    }
}
