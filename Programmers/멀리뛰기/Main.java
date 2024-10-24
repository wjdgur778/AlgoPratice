package Programmers.멀리뛰기;

class Main {
    public long solution(int n) {
        long answer = 0;
        long[] ans = new long[n+3];
        ans[1] = 1;
        ans[2] = 2;
        for(int i =3;i<=n;i++){
            ans[i]%=1234567;
            ans[i] =( ans[i-1]%1234567) + (ans[i-2]%1234567);
        }
        return ans[n]%1234567;
    }
}