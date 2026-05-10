class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int first = func(nums,goal);
        int second = func(nums,goal-1);
        return first - second;
    }
    public static int func(int[] nums, int goal){
        if(goal<0) return 0;
        int n = nums.length;
        int left = 0, right = 0,sum = 0, count = 0;
        while(right<n){
            sum += nums[right];
            while(sum>goal){
                sum -= nums[left];
                left++;
            }
            count+= right-left+1;
            right++;
        }
        return count;
    }
}