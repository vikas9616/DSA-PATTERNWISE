class Solution {
    public int removeDuplicates(int[] nums) {
        int res=1;
        if(nums.length <= 2) return nums.length;
        int fast=2, slow=2;
        int count=2;
        while(slow <nums.length){
            if(nums[slow] != nums[fast-2]){
                nums[fast++] = nums[slow];
            }
            slow++;
        }
        return fast;
    }
}