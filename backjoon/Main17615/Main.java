package backjoon.Main17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
        OOOOXXOOO
        OOOXXXOOXXXOOXXXX
        OXOXXOXOOOXOXOXXOXO
        XOOOXOXXX
        XXOOXOXOXXOO
        RRBBRBRBRRBB
     */
    static String str;
    static int N;
    static int red;
    static int blue;
    static int answer;

    public static void main(String arg[]) throws IOException {
        //2가지의 ball이 존재
        //한쪽끝으로 한가지의 ball을 옮기자
        //최소한의 이동횟수로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'R') red++;
            else blue++;
        }
        if (red == 0 || blue == 0) {
            System.out.println(0);
        }
        else{
            int s = 0;
            int e = str.length() - 1;
            char sc = str.charAt(s);
            char ec = str.charAt(e);
            while (str.charAt(++s) == sc) ;
            while (str.charAt(--e) == ec) ;

            //양쪽끝이 같을때
            //같으면 무조건 끝에서 연속된 친구가 긴쪽으로 세야함,
            // 그 이동횟수랑 또 다른 ball의 갯수랑 비교하자자            //RRBBBRBRBRRRR
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                int cnt = 0;
                Character base = sc;
                if (s > N - 1 - e) {
                    cnt = s;
                } else {
                    cnt = N - 1 - e;
                }
                if (base == 'R') {
                    answer = red - cnt < blue ? red - cnt : blue;
                } else answer = blue - cnt <  red ? blue - cnt : red;
            }
            //양쪽끝이 다를때
            else {
                if (sc == 'R') {
                    answer = red - s < blue - (N - 1 - e) ? red - s : blue - (N - 1 - e);
                } else {
                    answer = blue - s < red - (N - 1 - e) ? blue - s : red - (N - 1 - e);
                }
            }
            System.out.println(answer);
        }

    }
}
