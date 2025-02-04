package backjoon.Main19947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int Y;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        calc(H,Y);
        System.out.println(ans);

    }
    static void calc(int cur_H,int cur_Y){
        if (cur_Y==0) {
            ans = Math.max(cur_H,ans);
            return;
        }

        if(cur_Y>=5){
            calc((int) (cur_H+(cur_H*0.35)),cur_Y-5);
        }if(cur_Y>=3){
            calc((int) (cur_H+(cur_H*0.20)),cur_Y-3);
        }if(cur_Y>=1){
            calc((int) (cur_H+(cur_H*0.05)),cur_Y-1);
        }

    }

}
