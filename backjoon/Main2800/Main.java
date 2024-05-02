package backjoon.Main2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] arr;
    static int[] check;
    static LinkedList<Integer> list;
    static int count=1;
    static int open;
    static int[] select;
    static ArrayList<String> answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        check = new int[arr.length];
        list = new LinkedList<>();
        answer = new ArrayList<>();
        // 괄호를 짝을 지어주고 combination으로 경우의수를 print해보자
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='('){
                open++;
                check[i]=count;
                list.add(count++);
            }
            if(arr[i]==')'){
                check[i]=list.pollLast();
            }
        }
        select = new int[arr.length];
        // 1 12 123
        /*
           1 12 123
           2 23
           3
         */
        for (int i = 1; i <=open ; i++) {
            Set<Integer>set = new HashSet<>();
            combi(i,1,0,set);
        }
        answer.sort((i,j)->i.compareTo(j));
        for (int i = 0; i < answer.size(); i++) {
            if(i!=0&&answer.get(i-1).equals(answer.get(i)))continue;
            System.out.println(answer.get(i));
        }
    }
    static void add(Set<Integer> s){
       StringBuilder sbb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(!s.contains(check[i])){
                sbb.append(arr[i]);
            }
        }
        answer.add(sbb.toString());
    }
    static void combi(int max,int idx,int cnt,Set<Integer>s){
        if(max==cnt) {
            add(s);
            return;
        }
        for (int i = idx; i <= open; i++) {
            s.add(i);
            combi(max,i+1,cnt+1,s);
            s.remove(i);
        }
    }
//    1 2 3 4
//    =>1 ,2 , 3 , 4 , 1 2, 2 3, 3 4
}
