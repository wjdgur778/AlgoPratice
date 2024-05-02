package backjoon.Main15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot{
    int idx;
    int cnt;
    Robot(int idx ,int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}
public class Main {

    //길이가 N인 컨베이어 벨트 위에
    //길이가 2N인 벨트가 돌아
    //회전을 하다보면 해당 칸의 내구도가 계속해서 변화하기 때문에
    //로봇이 N번 칸까지 가기 위해 스스로 움직이거나 벨트를 돌릴것이다.
    //이동할때 실제로 arr의 값을 이동시키는 것이 아니라 index를 잘 활요하면 할 수 있을듯

    /*
       1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
       2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
           2-1.로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
       3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
       4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
     */
    static int N,K;
    static int[] arr;
    static int w_cnt;
    static int zeros;
    static boolean[] check;
    /*
        1 2 3 4 5 6 7 8 9 10
        N만큼을 반복하되 현재 자리에서!
        N - 1 - cnt
     */
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N*2];
        check = new boolean[N*2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N*2; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(w_cnt);
    }

    private static void solve() {
        Queue <Robot> q = new LinkedList<Robot>();
        int start = (2*N)-1;
        // 0 1 2 3 4 5
        // 앞으로 2번은 뒤로 N-2번
        // s % N 앞으로
        // N - (s%N) 뒤로
        // (N - 1 - (start % N) )  ;
        int c = 0;
        while(zeros<K){
            //벨트 회전
            start++;
            int size = q.size();

            while(size>0){
                Robot cur = q.poll();
                if(cur.cnt+1!=N) {
                    q.offer(new Robot(cur.idx, cur.cnt + 1));
                }
                //로봇이 내린 순간
                else{
                    check[(cur.idx)%(2*N)]=false;
                }
                size--;
            }
            //로봇 이동
            //idx 와 cnt 바뀜
            size = q.size();
            while(size>0){
                Robot cur = q.poll();
                int c_idx = (cur.idx+1)%(N*2);
                //이동할 수 있을때
                if(!check[c_idx]&&arr[c_idx]>=1){
                    check[(cur.idx)%(N*2)]=false;
                    //다음 이동으로 로봇이 도착하지 않을때만
                    if(cur.cnt+1!=N) {
                        check[c_idx] = true;
                        q.offer(new Robot(cur.idx + 1, cur.cnt + 1));
                    }
                    arr[c_idx]--;
                    if (arr[c_idx] == 0) {
                        zeros++;
                    }
                }
                else
                    q.offer(cur);
                size--;
            }
            //올리는 위치에 올리기
            int loc = (2*N) - 1 - (start)%(2*N);
            if(arr[loc]!=0){
                check[loc]=true;
                arr[loc]--;
                if(arr[loc]==0){
                    zeros++;
                }
                q.offer(new Robot(loc,1));
            }
            w_cnt++;

        }
    }
}
