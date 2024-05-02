package Programmers.KAKAO2022_신고결과받기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 4;
        int n = 437674;
        int num =867581;
        int answer = 0;
        Set<Integer>set = new HashSet<>();
         String s = "";
        while (num != 0) {
            s = (num % k) + s;
            num = num / k;
        }
        System.out.println(s);
        String[] arr = s.split("0");

        for (String tmp : arr) {
            if(tmp.isEmpty())continue;
            System.out.println("o:" +tmp);
//            int p = Integer.parseInt(tmp);
//            if (isPrime(p)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isPrime(int p) {
        //에라토스테네스의 체를 사용해야하남 호호
        //안써도 통과하는지 보자
            if(p==1)return false;
            if(p==2)return true;
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) return false;
        }
        return true;
    }

}
