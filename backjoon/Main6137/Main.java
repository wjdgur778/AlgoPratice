package backjoon.Main6137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder T_sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(br.readLine());
        }
        String str = sb.toString();
        int s = 0;
        int e = N - 1;
        for (int i = 0; i < N; i++) {
            char sc = str.charAt(s);
            char ec = str.charAt(e);
            //앞, 뒤 확인
            //앞이 사전 순으로 앞설 때
            if (sc < ec) {
                T_sb.append(sc);
                s++;
            }
            // 뒤가 사전순으로 앞설 때
            else if (sc > ec) {
                T_sb.append(ec);
                e--;
            } else {
                boolean front = true;
                int ts = s + 1;
                int te = e - 1;
                while (ts < te) {
                    if (str.charAt(ts) > str.charAt(te)) {
                        front = false;
                        break;
                    }else if (str.charAt(ts) < str.charAt(te)){
                        break;
                    }
                    ts++;
                    te--;
                }
                if (front) {
                    T_sb.append(sc);
                    s++;
                } else {
                    T_sb.append(ec);
                    e--;
                }
            }
        }

        if (T_sb.length() <= 80) System.out.print(T_sb.toString());
        else {
            int i = 0;
            int j = 80;
            while(true){
                if(j>T_sb.length()){
                    System.out.print(T_sb.substring(i,T_sb.length()));
                    break;
                }
                System.out.println(T_sb.substring(i,j));
                i=j;
                j+=80;
            }
        }

    }
}
