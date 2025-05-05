class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int []res = new int[100];
        int count=0;
        for(int[] d: dominoes){
            int temp = d[0]<d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            count += res[temp];
            res[temp]++;
        }
        return count;
    }
}