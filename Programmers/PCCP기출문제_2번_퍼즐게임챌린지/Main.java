//package Programmers.PCCP기출문제_2번_퍼즐게임챌린지;
//
//class Solution {
//    static final int MAX = 100000;
//    public int solution(int[] diffs, int[] times, long limit) {
//        return binary_search(diffs,times,limit);
//    }
//    public int binary_search(int[] diffs, int[] times, long limit){
//        int level_s = 1;
//        int level_e = MAX;
//        //limit을 넘으면 level을 늘려보고
//        //limit을 넘지 않으면 level을 줄여본다.
//        int mid = 0;
//        int answer = MAX;
//        while(level_s<= level_e){
//            mid = (level_s + level_e )/ 2;
//            if(limit < calc(diffs,times,mid)){
//                level_s = mid + 1;
//                System.out.println(mid);
//            }
//            else{
//                //limit와 같거나 그 이내로 들어오는 mid
//                answer = Math.min(answer,mid);
//                level_e = mid - 1;
//            }
//        }
//        return answer;
//
//    }
//    public long calc(int[] diffs, int[] times,int level){
//        long prev = times[0];
//        long sum = times[0] ;
//        for(int i =1 ;i< diffs.length;i++){
//            if(level<diffs[i]){
//                sum += (prev+times[i])*(diffs[i]-level) + times[i];
//            }
//            else {
//                sum+= times[i];
//            }
//            prev = times[i];
//        }
//        return sum;
//    }
//}