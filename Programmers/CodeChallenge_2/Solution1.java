package Programmers.CodeChallenge_2;

import java.util.*;
/*
2025 프로그래머스 코드챌린지 2차 예선
서버 증설 횟수
 */
class Solution1 {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] cur_server = new int[players.length];
        for(int i =0;i<players.length;i++){

            if(players[i]/m>cur_server[i]){
                int add_cnt =  (players[i]/m) - cur_server[i];
                for(int j =i ;j<players.length&&j<i+k;j++)
                    cur_server[j] +=add_cnt;
                answer+=add_cnt;
            }

        }
        return answer;
    }
}