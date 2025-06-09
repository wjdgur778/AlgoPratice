package practice;

import java.util.HashSet;

public class DebugTest {
    public static   void main(String[] args) {
        int[][] q = {
                {1,2,3,4,5},
                {1,2,3,4,6},
                {1,2,3,4,7},
                {1,2,3,4,8},
                {1,2,3,4,9}
        };
        int[] ans = {2,3,4,3,3};
        DebugTest debugTest = new DebugTest();
        System.out.println(debugTest.solution(5,q,ans));
    }
    static int result=0;
    public int solution(int n, int[][] q, int[] ans) {

        HashSet<Integer> set  = new HashSet<Integer>();

        calc(1,5,0,set,q,ans,5);

        return result;
    }
    public void calc(int cur,int max,int cnt,HashSet<Integer>set,int[][]q,int[] ans,int n){
        if(cnt==max){
            System.out.println("cnt :"+ cnt);

            for(int a : set)System.out.print(a+" ");
            System.out.println();
            //ans 테스트
            for(int i =0;i<q.length;i++){
                int c_ans =0 ;
                for(int j =0;j<5;j++) if(set.contains(q[i][j]))c_ans++;
                if(ans[i]!=c_ans){
                    return;
                }
            }
            result++;
            return;
        }
        for(int i =cur;i<=n;i++){
            set.add(i);
            calc(i+1,max,cnt+1,set,q,ans,n);
            set.remove(i);
        }
    }
}
