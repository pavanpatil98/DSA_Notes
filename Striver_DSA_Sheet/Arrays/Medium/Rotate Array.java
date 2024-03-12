//Rotate Array https://leetcode.com/problems/rotate-array/description/
//Brute Force
class Solution {
    public void rotate(int[] nums, int k) {
        int finalK = k%nums.length;
        if(finalK==0)return;

        int[] ans = new int[nums.length];
        int idx = nums.length-1;
        for(int i=finalK-1;i>=0;i--){
            ans[i] = nums[idx--];
        }
        idx = 0;
        for(int i=finalK;i<ans.length;i++){
            ans[i] = nums[idx++];
        }

        for(int i=0;i<ans.length;i++){
            nums[i] = ans[i];
        }

    }
}

//Optimal Approach
class Solution {
    public void reverse(int[] arr,int i,int j){
        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int finalK = k%nums.length;
        if(finalK==0)return;
        int idx = nums.length-finalK;

        reverse(nums,0,idx-1);
        reverse(nums,idx,nums.length-1);
        reverse(nums,0,nums.length-1);

    }
}