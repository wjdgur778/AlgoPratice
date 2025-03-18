package backjoon.Main1622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         *      t h e
         * s
         * t    1 0 0
         * r    - - -
         * e    - - 1
         * e
         * t
         */
        String a="";
        String b="";
        while((a = br.readLine())!=null){
            int[] arr1 = new int[26];
            int[] arr2= new int[26];
            StringBuilder sb = new StringBuilder();
            b = br.readLine();
            for (int i = 0; i < a.length(); i++) arr1[a.charAt(i)-97]++;
            for (int i = 0; i < b.length(); i++) arr2[b.charAt(i)-97]++;
            for (int i = 0; i < 26; i++) {
                int cnt = Math.min(arr1[i],arr2[i]);
                for (int j = 0; j <cnt ; j++) {
                    sb.append((char)(i+97));
                }
            }
            char[] tmp = sb.toString().toCharArray();
            Arrays.sort(tmp);
            System.out.println(String.valueOf(tmp));
        }
    }
}
