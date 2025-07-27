class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        int l=0;
        for(int i=1; i<=nums.length-2; i++){
           if(nums[i]!=nums[i+1]){
            if((nums[i]>nums[l] && nums[i]>nums[i+1]) || (nums[i]<nums[l] && nums[i]<nums[i+1]) ){
            count++;
           }
           l =i;
           }
        }
        return count;
    }
}