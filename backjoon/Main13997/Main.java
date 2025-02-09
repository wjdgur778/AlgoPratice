package backjoon.Main13997;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int T,N;
    static int ans;
    static HashSet<Integer> set;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        //내려가면서 둘다 switch on 되어있으면 나올때의 node num이 공통조상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            //init
            tree = new ArrayList[N+1];
            for (int j = 1; j < N+1; j++) {
                tree[j] = new ArrayList<>();
            }
            for (int j = 0; j < N-1; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[b].add(a);
            }
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            set = new HashSet<>();

            find(first);
            find(second);
        }

    }
    public static void find(int cur){


        if(set.contains(cur)){
            System.out.println(cur);
            return;
        }
        else{
            set.add(cur);
        }

        if(tree[cur].isEmpty())return;

        find(tree[cur].get(0));
    }
}
