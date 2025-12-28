package backjoon.Main3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main  {


    static class Data implements Comparable<Data>{
        int id;
        int sum;
        int cnt;
        int last_idx;

        Data(int id,int sum,int cnt,int last_idx){
            this.id = id;
            this.sum = sum;
            this.cnt =cnt;
            this.last_idx = last_idx;
        }
        public int compareTo(Data o){
            if(this.sum==o.sum){

                if(this.cnt==o.cnt){
                    return Integer.compare(this.last_idx,o.last_idx);
                }
                return Integer.compare(this.cnt,o.cnt);
            }
            return Integer.compare(o.sum,this.sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [] solve_cnt = new int[n+1];
            int [] t_score = new int[n+1];
            int [] t_last_idx = new int[n+1];
            int[][]scores = new int[n+1][k+1];
            for (int j = 0; j < m; j++) {
                st= new StringTokenizer(br.readLine());
                int t_id = Integer.parseInt(st.nextToken());
                int p_id = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                if(scores[t_id][p_id]<s){
                    scores[t_id][p_id]=s;
                }
                solve_cnt[t_id]++;
                t_last_idx[t_id]=j;
            }
            for (int j = 1; j <=n; j++) {
                int tmp =0 ;
                for (int l = 1; l <=k ; l++) {
                    tmp += scores[j][l];
                }
                t_score[j]=tmp;
            }
            PriorityQueue<Data>pq = new PriorityQueue<>();
            for (int j = 1; j <= n; j++) {
                pq.offer(new Data(j,t_score[j],solve_cnt[j],t_last_idx[j]));
            }
            int rank =1;
            while(pq.poll().id!=t){rank++;}

            System.out.println(rank);
        }
    }
}
