package backjoon.Main2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int w_cnt =0;
        boolean[] arr = new boolean[n+2];
        for (int i = 2; i <=n ; i++) {
            int cnt=1;
            int j = i;
            while(j*cnt<=n) {
                if(!arr[j*cnt]) {
                    arr[j*cnt]=true;
                    w_cnt++;
                    if(w_cnt==k){
                        System.out.println(j*cnt);
                        return;
                    }
                }
                cnt++;
            }

        }
    }
}
