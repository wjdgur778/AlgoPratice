package backjoon.Main16168;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 서로다른 그래프로 나뉘어 있는지 아닌지 확인(반드시 1개의 그래프만 존재해야함) (유니온 파인드)
 * 정점을 한붓 그리기로 이을 수 있는지 확인(오일러 경로)
 * - 정점에 이어져있는 간선의 갯수가 홀수인지 확인
 * - 홀수의 갯수가 0개 혹은 2개여야 한붓그리기 가능
 */

/**
 1. dfs를 활용하여 모든 정점이 이어져있고 하나의 그래프로 이어져있는지 확인
 2. 오일러경로를 활용하여 한붓 그리기가 가능한지 확인한다.
 <주의사항>
 유니온 파인드를 활용하여 그래프가 하나의 그래프만 존재하는지 확인하려 했으나 입력값에 따라
 확인하기 어려울 수 있다...
 유니온 파인드는 "CYCLE"을 확인할 때, 사용하자(ex: 크루스칼 )
 */
class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    //    static int odd=0;
    static int V, E;
    static int[] parents;
    static Map<Integer, Integer> Euler;
    static Pair[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        arr = new Pair[E];
        Euler = new HashMap<>();
        //init
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(a < b ? a : b, a > b ? a : b);
            if (Euler.containsKey(a)) Euler.replace(a, Euler.get(a) + 1);
            else Euler.put(a, 1);
            if (Euler.containsKey(b)) Euler.replace(b, Euler.get(b) + 1);
            else Euler.put(b, 1);
        }

        //부모 노드 초기화
        for (int i = 1; i <= V; i++) parents[i] = i;
        //그래프가 1개
        if (isGraph()) {
            int odd = 0;
            for (int item : Euler.keySet()) {
                if (Euler.get(item) % 2 != 0) odd++;
            }
            if (odd == 0 || odd == 2) System.out.println("YES");
            else System.out.println("NO");
        }
        //그래프가 2개 이상
        else System.out.println("NO");
    }

    static boolean isGraph() {
        //cycle 확인
        for (int i = 0; i < E; i++) {
            int a = get_p(arr[i].x);
            int b = get_p(arr[i].y);
            //부모가 같으면 연결되어있음
            //다르면 연결되어있지 않음
            if (a != b) {
                //A트리와 B트리를 이을때
                //B트리의 모든 노드를 A트리의 루트노드로 바꾸어주어야함
                //비교하는 해당노드 a와 b만 적용시키는 것이 아닌 union_p()를 사용
                union_p(a, b);
            }
            for (int ii = 1; ii <= V; ii++) {
                System.out.print(parents[ii]);
            }
            System.out.println();
        }

        int comp = parents[1];
        for (int i = 1; i <= V; i++) {
            if (parents[i] != comp) {
                return false;
            }
        }
        return true;
    }


    static int get_p(int n) {
        if (parents[n] == n) return n;
        else return parents[n] = get_p(parents[n]);
    }

    static void union_p(int x, int y) {
        x = get_p(x);
        y = get_p(y);
        if (x < y)
            parents[x] = y;
        else
            parents[y] = x;
    }


}
//4 5
//        4 2
//        3 2
//        4 1
//        3 1
//        2 1
