class Solution {
    public int findComplement(int num) {
        int n = (int)(Math.floor(Math.log(num)/Math.log(2))) +1;
        return ((1 << n)-1) ^ num;
    }
}