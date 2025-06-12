class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Math.abs(nums[0]-nums[nums.length-1]);
        for(int i=1;i<nums.length; i++){
            int d = Math.abs(nums[i-1]-nums[i]);
            max = Math.max(max,d);
        }

        return max;
    }
}