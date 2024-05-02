package Programmers.양과늑대;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static ArrayList<Integer>[] arr;
    static int answer;
    static int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
    static int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
    // result = 5

    /**
     * 가능한 노드를 추가해가면서 dfs?
     */
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {

        arr = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            arr[edges[i][0]].add(edges[i][1]);
        }
        ArrayList<Integer>arr = new ArrayList<>();
        arr.add(0);
        dfs(0, 0, 0, new ArrayList<>());

        return answer;
    }

    public static void dfs(int sheep, int wolf, int cur, ArrayList<Integer> nodes) {
        if (info[cur] == 0) sheep += 1;
        else wolf += 1;
        if (sheep <= wolf) return;
        System.out.println("cur : " + cur + " sheep: " + sheep + " wolf : " + wolf);
        ArrayList<Integer> tmp = new ArrayList<>();
        answer = answer < sheep ? sheep : answer;
        tmp.addAll(nodes);

        for (int i = 0; i < arr[cur].size(); i++) {
            tmp.add(arr[cur].get(i));
        }
        tmp.remove(Integer.valueOf(cur));
        for (int i = 0; i < tmp.size(); i++) {
            System.out.print(tmp.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < tmp.size(); i++) {
            int node =  tmp.get(i);
            dfs(sheep, wolf, node, tmp);
        }

    }

}
