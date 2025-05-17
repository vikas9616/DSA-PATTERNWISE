class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
       int count0 =0;
       int count1 =0;
       for(int i=0; i<n; i++){
        if(nums[i]==0){
            count0++;
        }
        if(nums[i]==1){
            count1++;
        }
       }
       for(int i=0; i<n; i++){
        if(i<count0){
         nums[i]=0;
        }
        if((i>=count0) && (i<count0+count1)){
         nums[i]=1;
        }
        else if((i >=(count1 + count0)) && ((count0 + count1) < n)){
         nums[i]=2;
        }
       }
    }
}