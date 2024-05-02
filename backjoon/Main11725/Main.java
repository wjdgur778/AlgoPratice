package backjoon.Main11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>>arr;
    static boolean[] check;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr=  new ArrayList<ArrayList<Integer>>();
        check = new boolean[N+1];
        answer = new int[N+1];
        for (int i = 0; i < N+1 ; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i <N-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
            arr.get(e).add(s);
        }
        check[1]=true;
        find(1);
        for (int i = 2; i <N+1 ; i++) {
            System.out.println(answer[i]);
        }
    }
    static void find(int cur){

        for (int i = 0; i < arr.get(cur).size(); i++) {
            int next = arr.get(cur).get(i);
            if(check[next])continue;
            check[next] = true;
            answer[next]=cur;
            find(next);
        }
    }
}
