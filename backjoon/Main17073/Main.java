package backjoon.Main17073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int W;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i <N-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        solution();
    }

    private static void solution() {
//      결론은 자식노드가 없는 노드들의 합을 전체 W로 나누어 소수점아래 4자리까지 나타내자
        System.out.printf("%.8f",(W/(double)find()));
    }
    private static int find(){
        int cnt=0;
        boolean[] check = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        check[1]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                boolean f = true;
                for (int j = 0; j <arr[cur].size() ; j++) {
                    if(check[arr[cur].get(j)]){
                        //모두 체크되어있으면 cnt++
                        continue;
                    }else f = false;
                    check[arr[cur].get(j)]=true;
                    q.offer(arr[cur].get(j));
                }
                if(f)cnt++;
            }
        }
        return cnt;
    }
}
