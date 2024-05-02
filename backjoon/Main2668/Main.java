package backjoon.Main2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    static int start;
    static boolean[] select;
    static ArrayList<Integer>list;
    static int answer;
    static Map<Integer,Integer> m;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//        arr = new ArrayList[N + 1];
//        select = new boolean[N+1];
//        list = new ArrayList<>();
//        for (int i = 1; i <= N; i++) {
//            arr[i] = new ArrayList<>();
//        }
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            arr[i].add(a);
//        }
//        solution();
        m = new HashMap<>() ;
        m.put(1,2);
        m.put(2,3);
        m.put(4,5);

        StringBuilder sb = new StringBuilder();
        String[] a = new String[10];
        String ss="100-200*300-500+20";
        String[] t = ss.split("[+|*|-]");

        for(String s : t)
            System.out.println(s);
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            if(select[i])continue;
            check = new boolean[N + 1];
            start = i;
            check[i] = true;
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            dfs(i, tmp);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }
    }

    private static void dfs(int cur, ArrayList<Integer> l) {
        int next = arr[cur].get(0);
        if (start == next) {
            for(int a : l){
                list.add(a);
                select[a]=true;
            }
            return;
        }
        if (check[next] == false) {
            check[next]= true;
            l.add(next);
            dfs(next,l);
        }
        return ;
    }
}
