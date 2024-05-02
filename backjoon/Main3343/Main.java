//package backjoon.Main3343;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int A, B, C, D;
//    static long N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        N = Long.parseLong(st.nextToken());
//        A = Integer.parseInt(st.nextToken());
//        B = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        D = Integer.parseInt(st.nextToken());
////        B/A 와 D/C 를 비교 하고 가성비가 더 좋은집에서 사는게 좋다.
////        하지만 마지막에  가성비가 좋은 집에서 사는게 좋을지 아니면 좋진 않더라도 적은
////        양의 꽃을 팔고있어서 그걸 사는게 좋을지? 판단하자
////        Binary Search 느낌이지만 꼭 그렇지도 않은 느낌?
//        System.out.println(solution());
//    }
//
//    private static long solution() {
//        long answer = 0;
////       1번집이 더 싸다
//        if ((double) B / (double) A < (double) D / (double) C) {
//            answer = (N / A) * B;
//            N = N % A ;
//        } else {
//            answer = (N / C) * D;
//            N = N % C;
//        }
//        int a = (N % A) > 0 ? 1 : 0;
//        int b = (N % C) > 0 ? 1 : 0;
//        answer += ((N / A) + a) * B > ((N / C) + b) * D ? ((N / C) + b) * D : ((N / A) + a) * B;
//        return answer;
//    }
////}
