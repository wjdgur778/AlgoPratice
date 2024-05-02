package LGuplusTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    static int n;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new ArrayList<Integer>();
        int sum = 0;
        String a = "1";

        String b = "2";
        System.out.println(a+b);
//        solve(new LinkedList<Integer>());
    }
    public static void solve(String str){

        if(str.length()!=0){
            answer.add(Integer.parseInt(str));
        }

        for(int i =0;i<10;i++){
            if(str.length()==0){
                solve(String.valueOf(i));
            }
        }
    }
}
