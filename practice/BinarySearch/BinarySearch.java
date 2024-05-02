package practice.BinarySearch;

public class BinarySearch {
    static int N;
    static int K;
    static int MAX = 99999;
    static int arr[]= {1,3,5,11,13,23,24,35,45};
    public static void main(String[] args) {
        int s=0;
        int e =arr.length-1;
        while(s<e){
            int mid =(s+e)/2;
            if(arr[mid]<K){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
    }
}
