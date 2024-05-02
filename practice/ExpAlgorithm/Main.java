package practice.ExpAlgorithm;

import java.util.Scanner;

public class Main {

    //((레벨-1) X 50 / 49) ^ 2.5 X 계수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int a = 0; a <= 100; a++) {
            int level =  (int)Math.pow(a,2.0/5.0)*49/50+1;
            System.out.println("경험치 : "+a+" "+ "레벨 : "+level);
        }
    }
}
