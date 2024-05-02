package backjoon.Main5525;

import java.util.Scanner;

public class Main {
    static String str;
    static int N, M;
    static int answer, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        str = sc.next();
        int idx = 0;
        boolean on = false;
        while (idx < M) {
            if (on == false && str.charAt(idx) == 'I') {
                cnt++;
                on = !on;
            } else if (on == true && str.charAt(idx) == 'O') {
                cnt++;
                on = !on;
            } else {
                if ((cnt - 1) / 2 >= N) answer += ((cnt - 1) / 2) - N + 1;
                //다시 처음으로
                on = false;
                if (cnt > 0) {
                    cnt = 0;
                    continue;
                }
            }
            idx++;
        }
        if ((cnt - 1) / 2 >= N) answer += ((cnt - 1) / 2) - N + 1;
        System.out.println(answer);
    }
}
