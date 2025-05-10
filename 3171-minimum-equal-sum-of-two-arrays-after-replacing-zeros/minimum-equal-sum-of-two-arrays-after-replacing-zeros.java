class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int max=0, res=0, min=0;
        long sum1=0, sum2=0;
        int countZero2=0, countZero1=0;
        for(int i=0; i<nums1.length; i++){
            if(nums1[i]==0){
                countZero1++;
            }
            sum1 += nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            if(nums2[i]==0){
                countZero2++;
            }
            sum2 += nums2[i];
        }
        sum1 += countZero1;
        sum2 += countZero2;
        if((sum1 > sum2 && countZero2 ==  0 )|| (sum2 > sum1 && countZero1==0)){
            return -1;
        }
        return Math.max(sum1 , sum2);
    }
}