package backjoon.Main2922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    /*
TODO
    상근이에게 즐거운 단어란, 모음(A,E,I,O,U)이 연속해서 3번,
    자음(모음을 제외한 나머지 알파벳)이 연속해서 3번 나오지 않아야 한다.
    또, L을 반드시 포함해야 한다.
    밑줄친 단어를 바꾸었을때 즐거운 단어가 되어야함
    100개 단어중에  _은 10개,
 */
    static int cnt_L = 0;
    static long ans1 = 0;
    static long ans2 =0 ;
    final static int AEIOU_CNT = 5;
    final static int OTHERS_CNT = 21;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder(br.readLine());
        String str = sb.toString();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'L') {
                cnt_L++;
            }
            if (sb.charAt(i) == '_') arr.add(i);
        }

        //L이 없을땐 전체에서 L이 없는경우  빼기
        if (cnt_L == 0) {
            makeFunnyWord(sb.toString(),0,0,0,1,0);
            makeFunnyWord(sb.toString(),0,0,0,1,-1);
            System.out.println(ans1 - ans2);
        }
        //L이 있을땐 신경쓰지말고 makeFunnyWord
        else {
            makeFunnyWord(sb.toString(),0,0,0,1,0);
            System.out.println(ans1);
        }

    }

    /*
    전체에서 L이 없는 경우의수를 빼?
    여기서 전체라는건 연속만 고려했을때
    이러면 두번 계산해야하는데..
     */
    public static void makeFunnyWord(String str, int idx, int aeiou, int others, long ans,int minus) {
        if (idx == str.length()) {
//            System.out.println("마무리 : "+ ans);
            if(minus==0)ans1 += ans;
            else ans2+=ans;
            return;
        }
        char ch = str.charAt(idx);
        if (ch != '_') {
            //모음이면
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                //연속이 안되는 선에서
                //모음을 넣을때는 자음을 0으로
                if (aeiou < 2) {
                    makeFunnyWord(str, idx + 1, aeiou + 1, 0, ans,minus);
                }
            }
            //자음이면
            //연속이 안되는 선에서
            //자음을 넣을때는 모음을 0으로
            else {
                if (others < 2) makeFunnyWord(str, idx + 1, 0, others + 1, ans,minus);
            }
        } else {
            //모음이 연속으로 2개면
            if (aeiou < 2) {
//                System.out.println("모음");
                makeFunnyWord(str, idx + 1, aeiou + 1, 0, ans * (AEIOU_CNT),minus);
            }
            if (others < 2) {
//                System.out.println("자음");
                makeFunnyWord(str, idx + 1, 0, others + 1, ans * (OTHERS_CNT+minus),minus);
            }
        }
    }
}
