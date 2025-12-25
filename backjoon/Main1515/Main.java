package backjoon.Main1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        // 9 1
        //다음 수가 있는게 좋음
        // 하나씩 확인하고 같아지면 그 전체를 사용할 수 있는지 확인
        int cur_n = 1;
        int c_idx = 0;
        while(c_idx<n){
            String cur_str = String.valueOf(cur_n);
            int checker =0;
            for (int i = 0; i <cur_str.length() ; i++) {
                if(cur_str.charAt(i)==str.charAt(c_idx)){
                    c_idx++;
                }
                if(c_idx==n)break;
            }
            cur_n++;
        }
        System.out.println(cur_n-1);
    }


}
