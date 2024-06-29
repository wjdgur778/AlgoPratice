package backjoon.Main20665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int s;
        int e;

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    static int N;
    static int T;
    static int P;
    static int[] time;
    static ArrayList<Pair> arr = new ArrayList<>();
    static ArrayList<Integer> seat = new ArrayList<>();
    static boolean[] sit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            StringBuilder s = new StringBuilder(st.nextToken());
            StringBuilder e = new StringBuilder(st.nextToken());
            String sh = s.substring(0, 2);
            String sm = s.substring(2, 4);
            String eh = e.substring(0, 2);
            String em = e.substring(2, 4);
            int sn = Integer.parseInt(sh) * 60 + Integer.parseInt(sm);
            int en = Integer.parseInt(eh) * 60 + Integer.parseInt(em);
            arr.add(new Pair(sn, en));
        }
        if (N == 1) {
            seat.add(1);
        } else if (N == 2) {
            seat.add(1);
            seat.add(N);
        } else {
            calc_seat();
        }
        solve();


    }

    private static void solve() {

        Collections.sort(arr,(i,j)->{
            if(i.s==j.s){
                if(i.e-i.s<j.e-j.s) return Integer.compare(i.s,j.s);
                else return Integer.compare(j.s,i.s);
            }
            return Integer.compare(i.s,j.s);
        });
//        PriorityQueue<>
        // 우선순위큐로 끝난친구들을 선별해서
        // 자리에서 일어나게하고 자리 순서를 확인하여 현재 친구를 자리에 앉힌다.
        // 앉힐때 관리자가 원하는 자리였다면 친구가 앉아있는 시간만큼 전체 time에서 뺀다.
        // 이를 친구들의 갯수만큼 반복한다.

        for (Pair cur : arr) {

            for (int seq : seat) {
                if(!sit[seq]){
                    sit[seq]=true;
                    break;
                }
            }
        }

    }

    static void calc_seat() {
        seat.add(1);
        seat.add(N);
        seat.add((1 + N) / 2);
        boolean[] check = new boolean[N + 1];
        check[1] = true;
        check[N] = true;
        check[(1+N)/2] = true;
        //2~ N-1까지 해봤더니
        //idx 가 구해지더라
        //이를 반복
        for (int j = 2; j < N-1; j++) {
            int max_cnt = 0;
            int idx = 0;
            for (int i = 2; i < N; i++) {
                int left = 0;
                int right = 0;
                if(check[i])continue;
                int cnt = 1;
                while (true) {
                    if (check[i - cnt] || check[i + cnt]) {
                        if(max_cnt<cnt){
                            idx = i;
                            max_cnt = cnt;
                        }
                        break;
                    }
                    cnt++;
                }
            }
            check[idx]=true;
            seat.add(idx);
        }

    }

    //짝수면
    //짝수가 우선순위, 그다음 왼쪽이 우선순위
    //분할 정복으로 안됨..
    //1 2 3 4 5 6 7 8 9
        /*
           1 9 5 3 7 2 4 6 8
         */


    /*
        ---------
   ----------
    --
    ---
      ---------
          ------

1 2 3 4 5 6 7 8
가장 멀리 떨어진다를 어찌 구현?

관리자가 원하는 좌석에 사람들이 얼마나 앉았는지를 더해서 마지막에 총 시간에서 뺀다.

가장 중요한 부분은 가장 멀리 떨어진 좌석에 앉히는 것

가장 멀리 떨어진 좌석에 앉히는 방법은 당연하게도 정해져 있다

배열로 정렬해놓고 계속 확인하는 방법은?

ex) 1 ~ 10
 -> 1 10 이때 1 이 사라지면? 다시 1
아무튼 순서는 있다
1 10 5 3 7 등 분할정복으로 가야하나?
1 2 3 4 5 6
그냥 마이너스로 할거면 홀수인쪽 먼저 뽑기

1 2 3 4 5 6 7 8 9
mid를 넣고, left부터 s,mid, mid+1,e


     */
}
