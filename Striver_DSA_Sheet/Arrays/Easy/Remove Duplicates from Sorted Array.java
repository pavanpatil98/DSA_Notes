//Approach
//I will Keep left & right at 0 then keep on incrementing right till n[left]==n[right]
//Then do n[++left] = n[right++];
//Also make sure to check right overflow outside inner loop
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int cnt = 0;

        while(right<nums.length){
            while(right<nums.length && nums[left]==nums[right]){
                right++;
            }
            if(right<nums.length){
                nums[++left]=nums[right++];
                cnt++;
            }
        }
        return cnt+1;
    }
}