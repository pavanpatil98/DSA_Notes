//https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems

/**
 This is typical pattern with HashMap & Prefix sum
 if you have prefix sum array you can any inbetween subarray sum
 so if array is  - - - x - - - y
 To get sum of subarray between x & y (x,y exclusive) is y-x
 **/

/*
Approach 1 Triple for loops
Approach 2 Dual for loops
Approach 3 HashMap & Prefix Sum (Works for positives & negatives)
Approach 4 Sliding Window (Only used when array contains poasitves)
 */

//Approach 3 HashMap & Prefix Sum (Works for positives & negatives)
import java.util.HashMap;

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        HashMap<Long,Integer> hmap = new HashMap<>();
        long cSum = 0;
        int max = 0;
        hmap.put(0L,-1);

        for(int i=0;i<a.length;i++){
            cSum+= a[i];
            long key = cSum-k;
            if(hmap.containsKey(cSum-k)){
                max = Math.max(max,i-hmap.get(cSum-k));

            }
            //Below if why necessary Iska exmaple
            /**
                2,0,0,3 & k=3
                Now
                 cSum = 2  & map [(0,-1),(2,0)]  idx = 0
                 cSum = 2  & map [(0,-1),(2,1)]  idx = 1
                 cSum = 2  & map [(0,-1),(2,2)]  idx = 2
                 cSum = 2  & map [(0,-1),(2,2),(5,3)]  idx = 3

                 So csum-k = 5-3 = 2
                 So 2 is map at 2 index so answer is = 3-2 = 1 (Wrong)

                 So below if makes sures that if got same value again we prefer not to update it
                 cSum = 2  & map [(0,-1),(2,0)]  idx = 0
                 cSum = 2  & map [(0,-1),(2,0)]  idx = 1
                 cSum = 2  & map [(0,-1),(2,0)]  idx = 2
                 cSum = 2  & map [(0,-1),(2,0),(5,3)]  idx = 3

                 So csum-k = 5-3 = 2
                 So 2 is map at 2 index so answer is = 3-0 = 3 (Correct)


            **/
            if(!hmap.containsKey(cSum)){
                hmap.put(cSum,i);
            }
        }
        return max;
    }
}


//Approach 4 Sliding Window Algorithm
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        int left = 0;
        int right = 0;
        long sum = 0;
        int cnt = 0;
        while(right<a.length){
            //int window = right-left+1;
            sum+=a[right];
            if(sum==k){
                cnt= Math.max(right-left+1,cnt);
            }
            else if(sum>k){
                while(sum>k){
                    sum-=a[left];
                    left++;
                }
                if(sum==k){
                    cnt= Math.max(right-left+1,cnt);
                }

            }
            right++;
        }

        return cnt;
    }