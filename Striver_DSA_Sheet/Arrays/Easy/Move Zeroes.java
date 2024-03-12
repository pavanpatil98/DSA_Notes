//Link https://leetcode.com/problems/move-zeroes/
//Approach
//Find first zero index(zidx)
//Then from one index ahead of (zidx) start checking with non zero elements & swap zeroidx with nonzeroidx do zeroidx++ & norzeroidx++

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int zidx = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){zidx=i;break;}
        }
        if(zidx == -1)return;
        idx = zidx+1;
        while(idx<nums.length){
            if(nums[idx]!=0){
                int temp = nums[idx];
                nums[idx] = nums[zidx];
                nums[zidx] = temp;
                zidx++;
            }
            idx++;
        }
    }
}