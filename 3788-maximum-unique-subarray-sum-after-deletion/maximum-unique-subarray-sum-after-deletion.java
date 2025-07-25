class Solution {
    public int maxSum(int[] nums) {
        int max = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
           hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> en : hm.entrySet()){
            if(en.getKey()>0)
            {
                max += en.getKey();
            }
        }
        Arrays.sort(nums);

        if(nums[nums.length-1]<0) return nums[nums.length-1];
        return max;
    }
}