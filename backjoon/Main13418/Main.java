package backjoon.Main13418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int x, y, d;

    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    static int N, M;
    static List<Node> list;
    static int[] parents;
    static int asc, desc;
    static int answer;
    static int first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y, d));
        }

        //init
        asc=0;
        for (int i = 0; i <= N; i++) parents[i] = i;
        //오름차순
        list.sort((i, j) -> Integer.compare(i.d, j.d));
        soltuion();
        answer = (asc*asc);

        //init
        asc=0;
        for (int i = 0; i <= N; i++) parents[i] = i;
        //내림차순
        list.sort((i, j) -> Integer.compare(j.d, i.d));
        soltuion();
        answer = Math.abs(asc*asc - answer);

        System.out.println(answer);
    }

    public static void soltuion() {
        for (int i = 0; i < list.size(); i++) {
            int a = get_p(list.get(i).x);
            int b = get_p(list.get(i).y);
            //연결되어있지 않다면
            if(a!=b){
                parents[a] = b;
                if(list.get(i).d==0)asc+=1;
            }
        }
    }

    public static int get_p(int c) {
        if (parents[c] == c) return c;
        else return parents[c] = get_p(parents[c]);
    }
}
