package backjoon.Main1254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int s = i;
            int e = n-1;
            boolean able = true;
            while(s<e){
                if(str.charAt(s)!=str.charAt(e)) {
                    able = false;
                    break;
                }
                s++;
                e--;
            }
            if(able){
                idx = i;
                break;
            }
        }
        System.out.println(n+idx);
    }
}
