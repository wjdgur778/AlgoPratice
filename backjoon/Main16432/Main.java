package backjoon.Main16432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 16432
 * 떡장수와 호랑이
 * https://www.acmicpc.net/problem/16432
 *
 *
 * 떡장수 동희는 매일 새벽에 갓 만든 떡을 들고 산을 넘어 장터로 가서 떡을 팝니다. 동희가 만드는 떡의 종류는 1번부터 9번까지 있습니다.
 * 산에는 동희가 나타나기를 기다렸다가 동희를 협박하여 떡을 하나 가져가는 호랑이가 살고 있습니다.
 * 이 호랑이는 입맛이 까다로워 전날에 먹었던 떡과 같은 종류의 떡이면 먹지 않습니다.
 * 만약 줄 수 있는 떡이 없다면 동희는 호랑이에게 잡아먹히고 맙니다.
 * 동희는 N일 동안 떡을 팔러 매일 장터에 나가야 합니다. 동희가 만드는 떡들의 종류는 재료 공급 사정에 따라 종류가 매일 달라집니다.
 * 동희가 N일 동안 호랑이에게 잡아먹히지 않도록 호랑이에게 줄 떡들을 골라주세요.
 */
public class Main {
    static int N;
    static int M;
    static int arr[][];
    static boolean check[][];
    static boolean stop;
    static LinkedList<Integer>ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        ans = new LinkedList<Integer>();
        check = new boolean[1001][11];
        stop = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            arr[i]=new int[M];
            for (int j = 0; j < M; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }

        }

        //전날과 다르기만 하면됨
        /**
         * 1234
         * 2345
         * 3456
         * 5678
         * 7891
         */

        dfs(-1,0);
        if(stop)System.out.println(-1);
    }
    static void dfs(int pre,int cnt){
        if(cnt==N){
            for(int a : ans){
                System.out.println(a);
            }
            stop = false;
            return;
        }

            for (int i =  0; i < arr[cnt].length; i++) {
                if (pre!=arr[cnt][i]&&check[cnt][arr[cnt][i]]==false && stop) {
                    ans.addLast(arr[cnt][i]);
                    check[cnt][arr[cnt][i]]=true;
                    dfs(arr[cnt][i],cnt + 1);
                    ans.removeLast();
                }
            }

    }
}
/**
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 *
 */
