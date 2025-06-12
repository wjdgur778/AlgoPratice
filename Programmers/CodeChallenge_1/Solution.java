package Programmers.CodeChallenge_1;

import java.util.*;
/*
2025 프로그래머스 코드챌린지 1차 예선
지게차와 크레인
*/
class Solution {
    class Data{
        int x;
        int y;
        Data(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }
    int cnt =0;
    char[][] map;
    public int solution(String[] sto, String[] req) {
        map = new char[sto.length+2][sto[0].length()+2];
        for(int i =0;i<map.length;i++)Arrays.fill(map[i],' ');
        for(int i =0;i<sto.length;i++){
            for(int j =0;j<sto[0].length();j++)
                map[i+1][j+1] = sto[i].charAt(j);
        }


        int answer = sto.length * sto[0].length();
        for(int k =0 ;k<req.length;k++){
            ArrayList<Data>tmp = new ArrayList<Data>();
            //알파벳 1개(겉면을 훑고 지나야한다.)
            if(req[k].length()==1){
                bfs(0,0,req[k].charAt(0),tmp);
            }
            //알파벳 2개
            else{
                for(int i =0;i<map.length;i++){
                    for(int j =0;j< map[0].length;j++){
                        if(map[i][j]==req[k].charAt(0)){
                            tmp.add(new Data(i,j));
                        }
                    }
                }
            }
            //     for(int i =0;i<map.length;i++){
            //             for(int j =0;j<map[0].length;j++){
            //                 System.out.print(map[i][j]);
            //             }
            //     System.out.println();
            // }
            pullout(map,tmp);

        }
        for(int i =0;i<map.length;i++){
            for(int j =0;j<map[0].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        return answer-cnt;
    }

    public void bfs(int x, int y,char target,ArrayList<Data> tmp){
        int N = map.length;
        int M = map[0].length;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        boolean[][] check = new boolean[map.length][map[0].length];
        Queue<Data>q = new LinkedList<Data>();
        q.offer(new Data(x,y));
        check[x][y]=true;

        while(!q.isEmpty()){

            int size = q.size();
            for(int i =0;i<size;i++){
                Data cur = q.poll();
                for(int j =0;j<4;j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>M-1)continue;
                    if(check[nx][ny])continue;
                    if(map[nx][ny]==target){
                        check[nx][ny]=true;
                        tmp.add(new Data(nx,ny));
                    }
                    if(map[nx][ny]!=' ')continue;

                    check[nx][ny] = true;
                    q.offer(new Data(nx,ny));
                }
            }


        }

    }
    public void pullout(char[][] map,ArrayList<Data>tmp){

        for(Data d : tmp){
            cnt++;
            map[d.x][d.y] = ' ';
        }
    }

}