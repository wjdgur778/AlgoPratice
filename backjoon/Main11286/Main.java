package backjoon.Main11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return Integer.compare(o1, o2);
                }
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(pq.isEmpty())System.out.println(0);
                else System.out.println(pq.poll());
            }
            else pq.offer(n);

        }
    }
}
