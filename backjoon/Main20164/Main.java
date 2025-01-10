package backjoon.Main20164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int min_ans = Integer.MAX_VALUE;
    static int max_ans = Integer.MIN_VALUE;

    static String number;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //한자리 수 or 두자리 수 이면 그냥 보고 답을 내면 된다.
        //세자리가 중요.
        calc_odds(st.nextToken(),0);
        System.out.println(min_ans+" "+max_ans);
    }

    public static void calc_odds(String cur, int sum) {
        int length = cur.length();
        int a=0;
        int b=0;
        int c=0;
        if (length == 1) {
            //지금까지의 홀수 min,max 정립
            min_ans = Math.min(min_ans, sum+count_odd(cur));
            max_ans = Math.max(max_ans, sum+count_odd(cur));
            return;
        } else if (length == 2) {
            int tmp = cur.charAt(0)-'0'+ cur.charAt(1)-'0';
            calc_odds(String.valueOf(tmp),sum+count_odd(cur));
        }
        else{
            //  3개로 나누기
            for (int i = 1; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    a=Integer.parseInt(cur.substring(0,i));
                    b=Integer.parseInt(cur.substring(i,j));
                    c=Integer.parseInt(cur.substring(j,length));
                    calc_odds(String.valueOf(a+b+c),sum+count_odd(cur));
                }
            }
        }

    }

    public static int count_odd(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0') % 2 == 1 ? 1 : 0;
        }
        return sum;
    }
}
