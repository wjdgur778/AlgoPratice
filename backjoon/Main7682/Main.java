package backjoon.Main7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
게임판의 상태가 주어지면, 그 상태가 틱택토 게임에서 발생할 수 있는 최종 상태인지를 판별하시오.
   X가 먼저 놓는다
   1. o가 x 보다 많으면 안됨
     1-2. 즉 무조건 같거나 한개 적어야됨
     1-3. O가 이기려면 무조건 같아야됨
   2. 최종 상태여야함 ( 누군가가 이기거나, 가득 차야함)
   3. 가득 찼을때
       3.1 한놈만 이기거나
       3.2 아무도 이기지 못해야함
   LOGIC
   if 가득찼다
        x가 o와 같거나 1개 많아야함
        아무도 이기지 않거나 한명만 이겨야함 -> 2명다 이기면 안댐
        xox
        xoo
        xox
   else
        꼭 한명만 이겨야됨
        o가 이긴상황에서는 o_cnt와 x_cnt가 같아야함
        x가 이긴상황에서는 x_cnt가 o_cnt와 같거나  1개 많아야함

 */
public class Main {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            str = br.readLine();
            if("end".equals(str))break;
            sb.append(solve(str)).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb.toString());
    }
    ///XOX
    // OXO
    // XO.
    private static String solve(String str) {
        int o_cnt=0;
        int x_cnt=0;
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)=='O')o_cnt++;
            else if(str.charAt(i)=='X')x_cnt++;
        }
        if(o_cnt==x_cnt||o_cnt+1==x_cnt){
            //가득찼을때는 아무도 이기지 않거나 한명만 이기거나 -> o가 이길수 없음 x가 이기거나 아무도 못이기거나
            //비어있을때는 꼭 한명이 이겨야함
                //o가 이길땐 갯수가 같아야함
                //x는 언제나 이길수 있음
            boolean[] c_arr= check(str);
            //o가 이길때
            if(o_cnt+x_cnt==9){
                //x만 이기거나
                if(!c_arr[0]&&c_arr[1])return "valid";
                //아무도 못이기거나
                if(!c_arr[0]&&!c_arr[1])return "valid";
                return "invalid";
            }
            //비어있을때
            else{
                //한명만 true 여야함
                if(c_arr[0]&&!c_arr[1]){
                    if(o_cnt==x_cnt)return"valid";
                    else return "invalid";
                }
                if(c_arr[1]&&!c_arr[0]){
                    if(o_cnt+1==x_cnt)return"valid";
                    else return "invalid";
                }
                return "invalid";
            }
        }
        else return "invalid";
    }
    private static boolean[] check(String str){
        boolean o_win=false;
        boolean x_win=false;

        // 가로 3개 새로 3개 대각선 2개
        //가로
        for (int i = 0; i < 3; i++) {
            char base = str.charAt(3*i);
            if(base=='.')break;
            if(base==str.charAt((3*i)+1)&&base==str.charAt((3*i)+2)){
                if(base=='O')o_win=true;
                else x_win= true;
            }
        }
        //새로
        for (int i = 0; i < 3; i++) {
            char base = str.charAt(i);
            if(base=='.')break;
            if(base==str.charAt(i+3)&&base==str.charAt(i+6)){
                if(base=='O')o_win=true;
                else x_win= true;
            }
        }
        //대각선
        //048
        //256
        char base = str.charAt(0);

        if(base!='.'&&base==str.charAt(4)&&base==str.charAt(8)){
            if(base=='O')o_win=true;
            else x_win= true;
        }

        base = str.charAt(2);
        if(base!='.'&&base==str.charAt(4)&&base==str.charAt(6)){
            if(base=='O')o_win=true;
            else x_win= true;
        }
        boolean[] tmp = {o_win,x_win};
        return tmp;
    }
}
