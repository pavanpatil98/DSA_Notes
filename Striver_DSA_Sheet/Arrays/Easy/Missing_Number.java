//https://leetcode.com/problems/missing-number/description/
class Solution {
    public int missingNumber(int[] nums) {
        //Way 1 Using Natural Sum Logic
        /*Sum all n & Sum all in array the difference is the answer

       /*int natural_sum = (nums.length*(nums.length+1))/2;
       int tsum = 0;
       for(int ele : nums)tsum+=ele;
       return natural_sum-tsum;*/

        //Way 2 Using XOR Operation
        //Example 3 0 1 -> 3^0 ^ 0^1 ^ 1^2 (Out of loop) ^ 3
        //Remaining -> 2 (As for xor a^a == 0  so a^a^b = b & it is commutative)
        int xor = 0, i = 0;
        for(i=0;i<nums.length;i++)xor=xor^i^nums[i];
        return xor^i;
    }
}