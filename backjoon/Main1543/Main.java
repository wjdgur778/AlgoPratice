package backjoon.Main1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String document;
    static String word;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        document = br.readLine();
        word = br.readLine();
        int idx=0;
        while(document.length()>idx) {
            if(idx+word.length()>document.length()) break;
            if(check(idx)) {
                idx += word.length();
                answer++;
            }
            else
                idx++;
        }
        System.out.println(answer);
    }
    static boolean check(int i){
        for (int j = 0; j < word.length(); j++) {
            if(document.charAt(i++)!=word.charAt(j))return false;
        }
        return true;
    }
}
