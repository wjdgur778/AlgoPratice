package backjoon.Main2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int[][] arr;
    static final int N = 9;
    static HashSet<Integer>[] gset;
    static HashSet<Integer>[] gset_w;
    static HashSet<Integer>[] gset_h;
    static boolean stop = false;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N][N];
        gset = new HashSet[N];
        gset_w = new HashSet[N];
        gset_h = new HashSet[N];
        for (int i = 0; i < N; i++) {
            gset[i] = new HashSet<Integer>();
            gset_w[i] = new HashSet<Integer>();
            gset_h[i] = new HashSet<Integer>();
        }

        //should follow the asc ord
        //init
        for (int i = 0; i < N; i++) {
              String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j)-'0';
                if(arr[i][j]!=0){
                    gset_w[i].add(arr[i][j]);
                    gset_h[j].add(arr[i][j]);
                    gset[3*(i/3)+(j/3)].add(arr[i][j]);
                }
//                System.out.println((i/3)+(j/3));
            }
        }

        solve(0);
    }
    public static void solve(int cnt){
        int i = cnt/N;
        int j = cnt%N;
//        System.out.println(cnt);
        if(cnt==81){
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < N; l++) {
                    System.out.print(arr[k][l]);
                }
                System.out.println();
            }
            stop = true;
            return;
        }
        if(arr[i][j]==0){
            for (int k = 1; k <=9 ; k++) {
                if(gset[3*(i/3)+(j/3)].contains(k))continue;
                if(gset_w[i].contains(k))continue;
                if(gset_h[j].contains(k))continue;
                arr[i][j] = k;
                gset_w[i].add(arr[i][j]);
                gset_h[j].add(arr[i][j]);
                gset[3*(i/3)+(j/3)].add(arr[i][j]);
                if(!stop)solve(cnt+1);
                gset_w[i].remove(arr[i][j]);
                gset_h[j].remove(arr[i][j]);
                gset[3*(i/3)+(j/3)].remove(arr[i][j]);
                arr[i][j] =0;
            }
        }
        else solve(cnt+1);

    }
}
