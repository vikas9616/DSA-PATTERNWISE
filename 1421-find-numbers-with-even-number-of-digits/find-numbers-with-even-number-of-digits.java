class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int i=0; i<nums.length; i++){
            int length = (int) (Math.log10(nums[i]) + 1);
            if(length%2==0){
                res++;
            }
        }
        return res;
    }
    // private boolean isEvenDigits(int [] nums){
    //     int count=0;

    // }
}