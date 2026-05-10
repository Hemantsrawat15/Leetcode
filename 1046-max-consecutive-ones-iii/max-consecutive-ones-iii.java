class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLength = 0;
        while(right<n){
            while(nums[right] == 0 && k<=0){
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
            if(nums[right] == 0 && k>0){
                k--;
            }
            int length = right-left+1;
            maxLength = Math.max(maxLength,length);
            right++;
        }
        return maxLength;
    }
}