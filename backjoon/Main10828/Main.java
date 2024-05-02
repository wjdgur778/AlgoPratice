package backjoon.Main10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10828

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        LinkedList<Integer>list = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                list.addFirst(num);
            }
            else if("top".equals(command)){
                if(list.size()==0)System.out.println(-1);
                else System.out.println(list.peekFirst());
            }
            else if("size".equals(command)){
                System.out.println(list.size());
            }
            else if("empty".equals(command)){
                if(list.isEmpty()){
                    System.out.println("1");
                }
                else
                    System.out.println("0");
            }
            else if("pop".equals(command)){
                if(list.size()==0)System.out.println(-1);
                else
                    System.out.println(list.pollFirst());
            }
        }
    }
}
