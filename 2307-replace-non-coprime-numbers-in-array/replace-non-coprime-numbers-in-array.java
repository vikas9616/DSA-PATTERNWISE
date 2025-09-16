class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Long> result = new ArrayList<>();

        for(int num : nums)
        {
            long currentNum = num;

            while(!result.isEmpty() && gcd(result.get(result.size() - 1), currentNum) > 1)
            {
                long lastElement = result.remove(result.size() - 1);

                currentNum = lcm(lastElement, currentNum);
            } 

            result.add(currentNum);
        }
        List<Integer> finalResult = new LinkedList<>();
        
        for(long val : result)
        {
            finalResult.add((int) val);
        }
        return finalResult;
    }
    private long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b)
    {
        if(a == 0 || b == 0) return 0;

        return (a * b) / gcd(a, b);
    }
}