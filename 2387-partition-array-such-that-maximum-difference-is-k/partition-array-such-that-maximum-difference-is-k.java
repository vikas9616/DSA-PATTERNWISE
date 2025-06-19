class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = nums[0];
        int res=1;
        for(int i=0; i<n; i++){
            if(nums[i]-l>k){
                res++;
                l=nums[i];
            }

        }
        return res;
    }
}