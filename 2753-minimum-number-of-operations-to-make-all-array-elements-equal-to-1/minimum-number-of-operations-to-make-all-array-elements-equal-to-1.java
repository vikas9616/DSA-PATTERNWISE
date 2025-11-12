class Solution {
    public int minOperations(int[] nums) {
        int gcd = 0;
        int onesCount = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<nums.length; i++)
        {
            if(nums[i] == 1)
            {   
                onesCount++;
            }
        }
        if(onesCount == 0)
        {   
            for(int i =0; i<nums.length; i++)
            {   
                gcd = nums[i];
                for(int j =i+1; j<nums.length; j++)
                {
                    gcd = check(gcd, nums[j]);
                    if(gcd == 1)
                    {
                        min = Math.min(min, j-i);
                        break;
                    }
                }
            }
        }
        else
        {
            return nums.length-onesCount;
        }
        if(min == Integer.MAX_VALUE)
        {
            return -1;
        }
    return min+nums.length-1;
    }
    static int check(int num1, int num2)
    {   
        while(num2 != 0)
        {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }
}