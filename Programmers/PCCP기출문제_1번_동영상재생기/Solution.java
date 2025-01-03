package Programmers.PCCP기출문제_1번_동영상재생기;

import java.util.*;
class Solution {
    public String solution(String vl, String p, String op_start, String op_end, String[] commands) {
        String answer = "";
        int pos = toSecond(p);
        int op_s = toSecond(op_start);
        int op_e = toSecond(op_end);
        if(op_s<=pos&&op_e>=pos){
            pos=op_e;
        }
        for(int i =0 ;i<commands.length;i++){
            String cmd = commands[i];
            //이동을 한 이후에 이 순간에 opening 구간이면 opening 끝으로

            if(cmd.equals("next")){
                pos += 10;
                int video_len = toSecond(vl);
                //영상의 끝이면
                if(pos>video_len){
                    pos = video_len;
                }
            }
            else{
                pos -=10;
                if(pos<0){
                    pos = 0;
                }
            }
            if(op_s<=pos&&op_e>=pos){
                pos=op_e;
            }

        }

        return toTimeString(pos);
    }
    public int toSecond(String str){
        String[] tmp = str.split(":");
        return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
    }

    public String toTimeString(int time){
        int min = time/60;
        int second = time%60;
        StringBuilder sb = new StringBuilder();
        if(min<10)sb.append("0");
        sb.append(min).append(":");
        if(second<10)sb.append("0");
        sb.append(second);
        return sb.toString();
    }
}