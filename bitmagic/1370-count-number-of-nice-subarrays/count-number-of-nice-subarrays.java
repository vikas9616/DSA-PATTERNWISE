class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, initialgap = 0, qsize=0, start=0;
        for(int i=0; i<nums.length; i++){
           if(nums[i]%2==1){
            qsize++;
           }

           if(qsize==k){
            initialgap=0;
            while(qsize==k){
              qsize -= nums[start] %2;
              initialgap++;
              start++;
            }
           }
           res = res+initialgap;
        }
        return res;
    }
}