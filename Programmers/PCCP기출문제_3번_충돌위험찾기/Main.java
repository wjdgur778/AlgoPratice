import java.util.*;
class Data{
    int x;
    int y;
    Data(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    //check 후 다음 step
    // 100 by 100 -> brute force
    // 모든 경로에 수를 적어?
    // 100 by 100 by 100으로 모든 경로의 cnt 를 적어서 모든 좌표에 겹치는 cnt가 있으면 answer++
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        HashMap<Integer,Integer>[][] check_cnt = new HashMap[101][101];


        boolean[][] check = new boolean[101][101];
        for(int i =0;i<101;i++){
            for(int j =0;j<101;j++){
                check_cnt[i][j] = new  HashMap<Integer,Integer>();
            }
        }

        //하나씩 최단 경로 기록
        //i 먼저 가고 다음 j
        //현재 좌표와 내가 가야할 좌표를 비교
        // r이 작다면 커야하고 크다면 작아져야한다 같아질때까지..
        // 그 이후 c를 똑같이 반복

        for(int i =0;i<routes.length;i++){
            Data s_idx = new Data(points[routes[i][0]-1][0],points[routes[i][0]-1][1]);
            int x = s_idx.x;
            int y = s_idx.y;
            int cnt = 0;
            if(check_cnt[x][y].containsKey(cnt)){
                check_cnt[x][y].put(cnt,check_cnt[x][y].get(cnt)+1);
            }
            else check_cnt[x][y].put(0,1);
            for(int j =1 ;j<routes[i].length;j++){
                Data e_idx = new Data(points[routes[i][j]-1][0],points[routes[i][j]-1][1]);

                //최단거리 cnt 기록
                while(e_idx.x!=x||e_idx.y!=y){
                    if(e_idx.x<x){
                        x--;
                    }
                    else if(e_idx.x>x){
                        x++;
                    }
                    else{
                        if(e_idx.y<y){
                            y--;
                        }
                        else if(e_idx.y>y){
                            y++;
                        }
                    }
                    cnt+=1;
                    if(check_cnt[x][y].containsKey(cnt)){
                        check_cnt[x][y].put(cnt,check_cnt[x][y].get(cnt)+1);
                    }
                    else check_cnt[x][y].put(cnt,1);
                }
            }

            //같은 좌표에 같은 시간대에 여러 로봇이 있다면 + 
            //같은 좌표에 또 다른 시간대에 여러 로봇이 있으면?? 
            //  

        }
        for(int i=0;i<101;i++){
            for(int j =0;j<101;j++){
                for(int key : check_cnt[i][j].keySet()){
                    if(check_cnt[i][j].get(key)>1)answer++;
                }
            }
        }
        return answer;
    }
}