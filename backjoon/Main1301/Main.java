package backjoon.Main1301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
임의의 연속된 3개의 구슬의 색을 모두 다르게 하려고 한다.
3
1
1
1
 */
public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.out.println(solution("one4seveneight"));
    }

    static Map<String, Integer> map;

    public static int solution(String s) {
        int answer = 0;
        String tmp = "";
        String ans = "";
        int size = s.length();
        s +="       ";
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int i =0 ;
        while(i<size){
            System.out.println(i);
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                ans+=s.charAt(i);
                i++;
            }
            else{
                for(int j =0;j<10;j++){
                    System.out.println(s.substring(i,i+arr[j].length()));
                    if(s.substring(i ,i+arr[j].length()).equals(arr[j])){
                        ans+=j;
                        i+=arr[j].length();
                        break;
                    }
                }
            }
        }        return Integer.parseInt(ans);

    }

}

