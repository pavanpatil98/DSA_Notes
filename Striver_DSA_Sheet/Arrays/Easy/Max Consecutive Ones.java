//Link https://leetcode.com/problems/max-consecutive-ones/
//Approach
//kahich nhi easy aahe
//just keep looping till you have one get max count of it


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int idx = 0;
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        while(idx<nums.length){
            cnt = 0;
            while(idx<nums.length && nums[idx]==1){
                cnt++;
                idx++;
            }
            max = Math.max(max,cnt);
            idx++; //This we can do as  in any case it is not 1
        }
        return max;
    }
}

max-consecutive-ones