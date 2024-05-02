package backjoon.Main2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int idx;
    int l;
    Pair(int idx, int l){
        this.idx =idx;
        this.l = l;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(l,o.l);
    }
}
public class Main {
    static int N;
    static ArrayList<Pair> answer;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        answer = new ArrayList<>();
        for (int i = 1; i <=N; i++) {
            arr[i] = new ArrayList<>();
        }
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1)break;
            arr[a].add(b);
            arr[b].add(a);
        }
        solution();

    }

    private static void solution() {
        ArrayList<Integer>ans = new ArrayList<>();
        int point=0;
        int num=1;
        for (int i = 1; i <=N ; i++) {
            bfs(i);
        }
        Collections.sort(answer);
        point = answer.get(0).l;
        ans.add(answer.get(0).idx);
        for (int i = 0; i <N-1 ; i++) {
            if(answer.get(i).l==answer.get(i+1).l){
                ans.add(answer.get(i+1).idx);
                num++;
            }
            else break;
        }
        Collections.sort(ans);
        System.out.println(point+" "+num);
        for(int i : ans) System.out.print(i+" ");
    }

    private static void bfs(int i) {
        int level=0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[N+1];
        q.offer(i);
        check[i]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int j = 0; j <size ; j++) {
                int cur = q.poll();
                for (int k = 0; k <arr[cur].size() ; k++) {
                    int next = arr[cur].get(k);
                    if(check[next])continue;
                    q.offer(next);
                    check[next]=true;
                }
            }
            level++;
        }
        answer.add(new Pair(i,level-1));
    }
}
